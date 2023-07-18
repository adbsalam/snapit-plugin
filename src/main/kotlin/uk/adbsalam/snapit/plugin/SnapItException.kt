package uk.adbsalam.snapit.plugin

/**
 * Exception for missing snapIt property
 * This will direct user regarding error and how this can be fixed
 */
val snapItExtentionException = Exception(
    """
        |Missing Properties
        | 
        |snapIt {
        |   testDir = "<TEST_DIRECTORY_HERE>"
        |   flavor = "<FLAVOR_NAME_HERE>"
        |} 
        |
        |missing from module build.gradle
        | 
        |Example: 
        |-If test location needs to be in src/test/java/com/example/tests 
        |-If flavor name is exampleFlav
        |
        |snapIt {
        |   testDir = "src/test/java/com/example/tests"
        |   flavor = "exampleFlav"
        |}
        | 
        |-If no multi flavors exist then simply set flavor = "debug"
        |
        | In module build.gradle add following property
        | 
        | snapIt {
        |   testDir = "src/test/java/com/example/tests"
        |   flavor = "debug"
        | }
        | NOTE: Release flavors are not allowed, thus no tests will be generated for release flavors
        | 
        | Once property added please try a refresh and build
    """.trimMargin()
)