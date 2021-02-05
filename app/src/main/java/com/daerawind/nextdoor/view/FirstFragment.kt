package com.daerawind.nextdoor.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daerawind.nextdoor.R
import com.daerawind.nextdoor.adapters.StoryAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val storyViewModel: StoryViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val storyAdapter = StoryAdapter()
        rv_stories.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_stories.adapter = storyAdapter

        storyViewModel.storiesLiveData.observe(viewLifecycleOwner, {
            // update adapter
            storyAdapter.submitList(it.stories)
        })

        storyViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
        }

        storyViewModel.getStories("1")

        // TODO: pagination
        // Add a scroll listener for recyclerview
        // when reached bottom of recycler view, make another api call for the next page
        // and attach to the existing data set
    }
}