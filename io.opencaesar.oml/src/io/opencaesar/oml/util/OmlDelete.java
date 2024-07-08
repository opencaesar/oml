/**
 * 
 * Copyright 2023 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package io.opencaesar.oml.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;

import io.opencaesar.oml.Element;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.Instance;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.NamedInstance;
import io.opencaesar.oml.Relation;

/**
 * Utilities to help delete Oml elements 
 */
public class OmlDelete {
	
    /**
     * Deletes the given element only
     * 
     * @param element the given element to delete
     */
    public static void delete(Element element) {
        EcoreUtil.remove(element);
    }

    /**
     * Deletes the given element and recursively all its referencing elements
     * 
     * @param element the given element to delete
     */
    public static void recursiveDelete(Element element) {
        var referencers = findReferencersToDelete(element);
        for (var referencer : referencers) {
        	delete(referencer);
        }
        delete(element);
    }

    /*
     * Returns a set of referencing elements that should be deleted if the given element is deleted
     * 
     * @param element the element to be deleted
     * @return the set of elements that also should be deleted if the given element is to be deleted
     */
	private static Set<Element> findReferencersToDelete(Element element) {
        final Set<Element> referencers = new LinkedHashSet<>();
        for (Element referencer : OmlSearch.findInverseReferencers(element, null, Element.class, null)) {
            if (referencer instanceof Member) {
            	var member = (Member) referencer;
            	if (!member.isRef()) {
            		referencers.addAll(findReferencersToDelete(member));
            	}
            }
        	referencers.add((Element)referencer);
        }
        return referencers;
	}

    /**
     * Determines all the elements that need to be deleted given an instance and a list of cascade rules
     * 
     * The elements are returned in a tree of cascade results specifying which elements are to be 
     * deleted based on which of the cascade rules. This can be used in the UI to show the user
     * the impact of deleting the element.
     * 
     * This function does not actually delete the elements. To do that, subsequently call 
     * {@link OmlDelete#recursiveDelete(CascadeResult)} passing it the returned cascade result.
     * 
     * @param instance The given instance to delete
     * @param cascadeRules A list of cascade rules
     * @return A root of a tree of cascade results
     */
    public static CascadeResult cascadeDelete(Instance instance, List<CascadeRule> cascadeRules) {
		var deleting = new HashSet<Instance>(Set.of(instance));
		var rootResult = new CascadeResult(instance);
		var queue = new ArrayDeque<CascadeResult>(Set.of(rootResult));

		while (!queue.isEmpty()) {
			var result = queue.poll();

			for (var rule : cascadeRules) {

				if (!rule.cascadesFrom(result.instance)) {
					continue;
				}
				
				if (rule.direction == CascadeDirection.SOURCE_TO_TARGET) {
					var targets = OmlSearch.findInstancesRelatedAsTargetTo(result.instance, rule.relation, null);
					for (var t : targets) {
						if (rule.cascadesTo(t)) {
							result.add(deleting, t, rule, queue);
						}
					}
				} else if (result.instance instanceof NamedInstance) {
					var sources = OmlSearch.findInstancesRelatedAsSourceTo((NamedInstance)result.instance, rule.relation, null);
					for (var s : sources) {
						if (rule.cascadesTo(s)) {
							result.add(deleting, s, rule, queue);
						}
					}
				}
			}
		}

		return rootResult;
	}

    /**
     * Deletes the given cascade result recursively
     * 
     * @param rootResult the given cascade rule to delete
     */
    public static void recursiveDelete(CascadeResult rootResult) {
		var queue = new ArrayDeque<CascadeResult>(Set.of(rootResult));
		while (!queue.isEmpty()) {
			var result = queue.poll();
			recursiveDelete(result.instance);
			for (var nested : result.nestedResults.values()) {
				queue.addAll(nested);
			}
		}
    }
    
	/**
	 * The enumeration of Cascade direction 
	 */
	public enum CascadeDirection {
		/**
		 * If source is deleted, also delete target 
		 */
		SOURCE_TO_TARGET,
		/**
		 * If target is deleted, also delete source 
		 */
		TARGET_TO_SOURCE
	}
	
	/**
	 * A cascade delete rule
	 * 
     * a) If direction is <code>SOURCE_TO_TARGET</code>, and
     * 	the instance to be deleted matches the given source type, 
     *  the instance to be deleted is related to a target instance with the given relation, 
     *  the target instance matches the given target type,
     *  delete the target instance;
     *      
     * a) If direction is <code>TARGET_TO_SOURCE</code>, and
     * 	the instance to be deleted matches the given target type, 
     *  the instance to be deleted is related to a source instance with the given relation, 
     *  the source instance matches the given source type,
     *  delete the source instance;
	 */
	public static class CascadeRule {
		/**
		 * The direction of the rule
		 */
		public CascadeDirection direction;
		/**
		 * The source type (can be null)
		 */
		public Entity sourceType;
		/**
		 * The relation of the rule
		 */
		public Relation relation;
		/**
		 * The target type (can be null)
		 */
		public Entity targetType;
		/**
		 * The description of the rule for UI
		 */
		public String description;

		/**
		 * Creates a new cascade rule
		 * 
		 * @param direction The direction
		 * @param sourceType The source type
		 * @param relation The relation
		 * @param targetType The target type
		 * @param description The description
		 */
		public CascadeRule(CascadeDirection direction, Entity sourceType, Relation relation, Entity targetType, String description) {
			this.direction = direction;
			this.sourceType = sourceType;
			this.relation = relation;
			this.targetType = targetType;
			this.description = description;
		}
		
		/**
		 * Checks if the rule can cascade from the given instance
		 *  
		 * @param instance The given instance
		 * @return true if the rule can cascade from the instance; otherwise false
		 */
		private boolean cascadesFrom(Instance instance) {
			var type = (direction == CascadeDirection.SOURCE_TO_TARGET) ? sourceType : targetType;
			return type == null || OmlSearch.findIsKindOf(instance, type, null);
		}

		/**
		 * Checks if the rule can cascade to the given instance
		 *  
		 * @param instance The given instance
		 * @return true if the rule can cascade to the instance; otherwise false
		 */
		private boolean cascadesTo(Instance instance) {
			var type = (direction  == CascadeDirection.SOURCE_TO_TARGET) ? targetType : sourceType;
			return type == null || OmlSearch.findIsKindOf(instance, type, null);
		}
	}
	
	/**
	 * A node in the cascade result tree
	 */
	public static class CascadeResult {
		/**
		 * The instance to delete
		 */
		public Instance instance;
		/**
		 * The nested cascade results
		 */
		public Map<String, List<CascadeResult>> nestedResults;;
		
		/**
		 * Creates a new cascade result
		 */
		private CascadeResult(Instance instance) {
			this.instance = instance;
			this.nestedResults = new LinkedHashMap<>();
		}
		
		/**
		 * Adds the given instance to the result
		 * @param deleting The set of elements to delete
		 * @param instance The given instance to delete
		 * @param rule The rule that caused the delete
		 * @param queue The queue to results
		 */
		private void add(HashSet<Instance> deleting, Instance instance, CascadeRule rule, Deque<CascadeResult> queue) {
			if (instance != null && deleting.add(instance)) {
				var result = new CascadeResult(instance);
				var list = nestedResults.computeIfAbsent(rule.description, k -> new ArrayList<CascadeResult>());
				list.add(result);
				queue.add(result);
			}
		}

	}
	
}
