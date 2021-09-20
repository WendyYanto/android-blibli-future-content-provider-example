package dev.wendyyanto.dictionaryappexample.constants

enum class Dictionary(val title: String, val description: String) {

    CONTENT_PROVIDER(
        "Content provider",
        "Android component that is used by the other app or our app to query the content provider"
    ),
    CONTENT_RESOLVER(
        "Content resolver",
        "Android component provides a public and safe interface to the access data in our app"
    ),
    DATA("Data", "Individual facts, statistics, or items of information"),
    STRING("String", "Any series of characters—letters, numbers, punctuation marks, and blanks"),
    XML("XML", "It is a notation for writing information structured as a hierarchy or family tree")
}