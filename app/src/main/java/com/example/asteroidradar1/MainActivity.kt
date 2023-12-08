package com.example.asteroidradar1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.asteroidradar1.databinding.ActivityMainBinding
import com.example.asteroidradar1.viewmodel.AsteroidViewModel
import com.example.asteroidradar1.viewmodel.PictureOfTheDayViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val asteroidViewModel: AsteroidViewModel by viewModels()
    private val PictureOfTheDayViewModel: PictureOfTheDayViewModel by viewModels()

//    private val viewModel: MainViewModel by viewModels {
//        MainViewModelFactory(AsteroidRepository(api))
//    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val adapter = AsteroidAdapter()
//        binding.recyclerViewAsteroids.adapter = adapter
//
//        viewModel.allAsteroids.observe(this, { asteroids ->
//            adapter.submitList(asteroids)
//        })

//        fun onCreateOptionsMenu(menu: Menu): Boolean {
//            menuInflater.inflate(R.menu.activity_main_menu, menu)
//            return true}

//        override fun onOptionsItemSelected(item: MenuItem): Boolean {
//            when (item.itemId) {
//                binding.actionViewWeekAsteroids.id -> {
//                    // Handle "View Week Asteroids" click
//                    // Show or navigate to the screen displaying week asteroids
//                    return true
//                }
//                binding.actionViewTodaysAsteroids.id -> {
//                    // Handle "View Today's Asteroids" click
//                    // Show or navigate to the screen displaying today's asteroids
//                    return true
//                }
//                binding.actionViewSavedAsteroids.id -> {
//                    // Handle "View Saved Asteroids" click
//                    // Show or navigate to the screen displaying saved asteroids
//                    return true
//                }
//                else -> return super.onOptionsItemSelected(item)
//            }
//        }

            // Observe changes in the asteroid data
//            asteroidViewModel.asteroids.observe(this) { asteroids ->
//                // Display asteroid information in TextViews
//                if (asteroids.isNotEmpty()) {
//                    val firstAsteroid = asteroids[0]
//                    binding.titleTextView.text = "Codename: ${firstAsteroid.codename}"
//                }
//            }

            // Fetch asteroids
            asteroidViewModel.fetchAsteroids("2023-01-01", "2023-12-31")
            // Fetch picture of the day
            PictureOfTheDayViewModel.fetchPictureOfTheDay()

            // Observe the LiveData from ViewModels and update UI accordingly
            asteroidViewModel.asteroids.observe(this) { _asteroids ->
                // Update UI with the list of asteroids
            }

            PictureOfTheDayViewModel.pictureOfTheDay.observe(this) { PictureOfTheDay ->
                Picasso.get().load(PictureOfTheDay.url).into(binding.PictureOfTheDayImageView)
            }

        }
    }

