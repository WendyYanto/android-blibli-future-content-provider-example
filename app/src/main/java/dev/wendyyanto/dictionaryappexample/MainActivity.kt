package dev.wendyyanto.dictionaryappexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.wendyyanto.dictionaryappexample.adapter.DictionaryAdapter
import dev.wendyyanto.dictionaryappexample.constants.Dictionary
import dev.wendyyanto.dictionaryappexample.databinding.ActivityMainBinding
import dev.wendyyanto.dictionaryappexample.model.DictionaryUiModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    private lateinit var dictionaryAdapter: DictionaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        setupAdapters()
    }

    private fun setupAdapters() {
        with(viewBinding.rvDictionaries) {
            dictionaryAdapter = DictionaryAdapter(getDictionaries())
            adapter = dictionaryAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun getDictionaries(): List<DictionaryUiModel> {
        return Dictionary.values().map { dictionary ->
            DictionaryUiModel(
                title = dictionary.title,
                description = dictionary.description
            )
        }
    }
}