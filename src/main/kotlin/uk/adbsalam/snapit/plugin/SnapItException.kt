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
        |   flavour = "<FLAVOUR_NAME_HERE>"
        |} 
        |
        |missing from module build.gradle
        | 
        |Example: 
        |-If test location needs to be in src/test/java/com/example/tests 
        |-If flavour name is exampleFlav
        |
        |snapIt {
        |   testDir = "src/test/java/com/example/tests"
        |   flavour = "exampleFlav"
        |}
        | 
        |-If no multi flavours exist then simply set flavour = "debug"
        |
        | In module build.gradle add following property
        | 
        | snapIt {
        |   testDir = "src/test/java/com/example/tests"
        |   flavour = "debug"
        | }
        | NOTE: Release flavours are not allowed, thus no tests will be generated for release flavours
        | 
        | Once property added please try a refresh and build
    """.trimMargin()
)