package com.example.asteroidradar1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.asteroidradar1.R
import com.example.asteroidradar1.databinding.ItemAsteroidBinding
import com.example.asteroidradar1.model.Asteroid

class AsteroidAdapter(private val context: Context) : RecyclerView.Adapter<AsteroidAdapter.AsteroidViewHolder>() {

    private var asteroids: ArrayList<Asteroid> = ArrayList()

    fun setItems(asteroid: List<Asteroid>) {
        asteroids.clear()
        asteroids.addAll(asteroid)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        val binding =
            ItemAsteroidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AsteroidViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        // val asteroid = asteroids[position]
        holder.bind(asteroids[position])
    }

    inner class AsteroidViewHolder(private val binding: ItemAsteroidBinding) :
        RecyclerView.ViewHolder(binding.root) {

//       init {
//           binding.root.setOnClickListener {
//               val position = adapterPosition
//               if (position != RecyclerView.NO_POSITION) {
//                   val asteroid = asteroids[position]
//                   context.toast("Clicked on asteroid: ${asteroid.name}")
//
//                   if (asteroids.isPotentiallyHazardous) {
//                       // Open the PotentiallyHazardousActivity
//                       val intent = Intent(context, PotentiallyHazardousActivity::class.java)
//                       // Pass any necessary data to the new activity
//                       intent.putExtra("asteroidName", asteroid.name)
//                       context.startActivity(intent)
//                   } else {
//                       // Handle non-hazardous click action if needed
//                       context.toast("Clicked on non-hazardous asteroid: ${asteroid.name}")
//                   }
//               }
//               }
//           }
//       }
//   }

        fun bind(currentItem: Asteroid) {
            binding.apply {
                textViewAsteroidName.text = currentItem.codename
                textViewEstimatedDiameter.text = currentItem.estimatedDiameter.toString()
                textViewRelativeVelocity.text = currentItem.relativeVelocity.toString()
                textViewDistance.text = currentItem.distanceFromEarth.toString()
                //binding.textViewHazardStatus = currentItem.isPotentiallyHazardous.()

                textViewHazardStatus.text = if (currentItem.isPotentiallyHazardous) {
                    "Potentially Hazardous"
                } else {
                    "Not Hazardous"
                }
                textViewCloseApproachDate.text = currentItem.closeApproachDate
                textViewAbsoluteMagnitude.text = currentItem.absoluteMagnitude.toString()

            }
        }
    }


    override fun getItemCount(): Int = asteroids.size
}

