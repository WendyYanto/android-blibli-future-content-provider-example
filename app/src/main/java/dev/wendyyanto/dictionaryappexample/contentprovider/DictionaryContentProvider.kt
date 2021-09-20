package dev.wendyyanto.dictionaryappexample.contentprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import dev.wendyyanto.dictionaryappexample.constants.Dictionary

class DictionaryContentProvider : ContentProvider() {

    companion object {
        private const val DICTIONARIES = 0
        private const val DICTIONARY_BY_INDEX = 1

        private const val AUTHORITY = "dev.wendyyanto.dictionaryappexample.dictionary"
        private const val PATH = "dictionaries"
    }

    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    private val items: MutableList<Dictionary> = mutableListOf()

    override fun onCreate(): Boolean {
        items.addAll(Dictionary.values())

        uriMatcher.addURI(AUTHORITY, PATH, DICTIONARIES)
        uriMatcher.addURI(AUTHORITY, "$PATH/#", DICTIONARY_BY_INDEX)

        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        val matrixCursor = MatrixCursor(arrayOf("title", "description"))

        when (uriMatcher.match(uri)) {
            DICTIONARIES -> {
                items.forEach { dictionary ->
                    matrixCursor.addRow(arrayOf(dictionary.title, dictionary.description))
                }
            }
            DICTIONARY_BY_INDEX -> {
                items.getOrNull(uri.lastPathSegment?.toInt() ?: 0)?.let { dictionary ->
                    matrixCursor.addRow(arrayOf(dictionary.title, dictionary.description))
                }
            }
        }

        return matrixCursor
    }

    override fun getType(uri: Uri): String? {
        return ""
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return uri
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        return 0
    }
}