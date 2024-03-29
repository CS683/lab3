package edu.bu.projectportal.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import edu.bu.projectportal.Project
import edu.bu.projectportal.R
import edu.bu.projectportal.viewmodel.CurProjectViewModel
import android.widget.CheckBox
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class DetailFragment : Fragment(R.layout.fragment_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        val projTitle = view.findViewById<TextView>(R.id.projTitle)
        val projDesc =  view.findViewById<TextView>(R.id.projDesc)
        val editProj = view.findViewById<ImageButton>(R.id.editProj)
        val authorsProj = view.findViewById<TextView>(R.id.projAuthors)
        val linkProj = view.findViewById<TextView>(R.id.projLink)
        val keywordsProj = view.findViewById<TextView>(R.id.projKeywords)
        val favoriteProj = view.findViewById<ImageView>(R.id.favoriteStar)

        val position:Int = arguments?.getInt("position")?:0

        Log.d("TAG","position:"+position)
        projTitle.text =  Project.projects[position].title
        projDesc.text = Project.projects[position].description
        authorsProj.text = Project.projects[position].authors.joinToString(separator = ", ")
        linkProj.text = Project.projects[position].link
        keywordsProj.text = Project.projects[position].keywords.joinToString(separator = ", ")

        val addProj: ImageView = view.findViewById(R.id.add)
        addProj.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_addProjectFragment)
        }

        //get the shared viewmodel objects using the activity scope
        val viewModel =
            ViewModelProvider(requireActivity()).get(CurProjectViewModel::class.java)

        // Create an observer for the curProject livedata.
        // Whenever its value changes, it is notified.
        // The project title and description will be loaded into textviews.
        viewModel.curProject.observe(viewLifecycleOwner, Observer {
            projTitle.text =  it?.title?:""
            projDesc.text = it?.description?:""
            authorsProj.text = it?.authors?.joinToString(separator = ", ")
            linkProj.text = it?.link?:""
            keywordsProj.text = it?.keywords?.joinToString(separator = ", ")
            favoriteProj.isSelected = it.isFavorite
        })



        editProj.setOnClickListener{
//             val action = DetailFragmentDirections
//                .actionDetailFragmentToEditFragment(position)
//            view.findNavController().navigate(action)
            view.findNavController().
            navigate(R.id.action_detailFragment_to_editFragment)
        }

    }
}