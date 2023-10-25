import glob 
import os
import sys

TARGET_REPO = sys.argv[1]

# all oml, omlxmi, and velocity files and subfiles starting from the root of the current working directory
FILES = glob.glob(os.path.join(TARGET_REPO, '**/*.oml'), recursive=True) + glob.glob(os.path.join(TARGET_REPO, '**/*.omlxmi'), recursive=True) + glob.glob(os.path.join(TARGET_REPO, '**/*.velocity'), recursive=True)

# Don't update files within the build directory
FILTERED_FILES = [i for i in FILES if "build" not in i]

# Dictionary where the keys correspond to the OML 1 syntax and the values correspond to the OML 2 syntax
OML2_SYNTAX = {
    ':>': '<',
    'ci ': 'instance ',
    'ri ': 'relation instance ',
    'ConceptTypeAssertion': 'TypeAssertion',
    'RelationTypeAssertion': 'TypeAssertion',
    'ScalarPropertyValueAssertion': 'PropertyValueAssertion',
    'LinkAssertion': 'PropertyValueAssertion',
    'FacetedScalar': 'Scalar',
    '<value': '<literalValue',
    '<ownedLinks': '<ownedPropertyValues',
    '</ownedLinks': '</ownedPropertyValues',
    '<relation': '<property',
    '<target': '<referencedValue',
    'target=': 'referencedValue=',
    '<ownedImports xsi:type="oml:DescriptionUsage"': '<ownedImports xsi:type="oml:Import" kind="usage"',
    '<ownedImports xsi:type="oml:DescriptionExtension"': '<ownedImports xsi:type="oml:Import" kind="extension"'
}

def update_files(old_str: str, new_str: str) -> None:
    """ Updates files that contains old string with new string. """
    for file in FILTERED_FILES:
        if os.path.isfile(file):
            print(file)
            with open(file, 'r') as f:
                content = f.read()
                
            content = content.replace(old_str, new_str)
            
            with open(file, 'w') as f: 
                f.write(content)
        
if __name__ == '__main__':
    for s in OML2_SYNTAX:
        print(f"# Update {s} to {OML2_SYNTAX[s]}")
        update_files(s, OML2_SYNTAX[s])