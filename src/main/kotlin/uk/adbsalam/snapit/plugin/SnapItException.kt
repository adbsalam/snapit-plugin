package uk.adbsalam.snapit.plugin

val snapItExtentionException = Exception(
    """property snapIt { <TEST SOURCESET LOCATION> } missing from module build.gradle
    | Please add snapIt { <TEST SOURCESET LOCATION> } to your module build.gradle
    | 
    | Example: If test location needs to be in src/test/java/com/example/tests 
    | In module build.gradle add following property
    | 
    | snapIt {
    |   testDir("com/example/tests")
    | }
    | 
    | Once property added please try a refresh and build
    """.trimMargin()
)