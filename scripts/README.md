# How to Use OML 2 Updater

### This updater can work with any OML repo.

1. Verify that you have Python 3 installed
2. Can install using HomeBrew, Chocolatey, Scoop, or from the Python website: https://www.python.org/downloads/
3. Assuming you are at the `root` of this repo, in any terminal run, `python oml2_updater.py <path_to_target_repo>`
4. Example: `python oml2_updater.py ~/kepler16b`
5. Then look for compile errors in *.oml files and manually do:
6. Replace <type> XXX < YYY [ ... ] by <type> XXX [ ... ] < YYY
7. Replace enumerated scalar XXX [ "yyy", "zzz", ... ] by scalar XXX [ oneOf "yyy", "zzz", ... ]
8. Replace [ restricts ... ] by < [ restricts ... ]
9. If there is a [ ... ] with restricts statements and other statements, separate them into different [ .. ] and put the restricts one after the < and the rest before the <
10. Verify that you can run `./gradlew build` after updating the OML model to OML 2
11. Look at https://www.opencaesar.io/projects/2023-7-21-OML-v2.html for more information 