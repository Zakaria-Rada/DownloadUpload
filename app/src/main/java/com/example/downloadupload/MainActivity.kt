package com.example.downloadupload

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage


class MainActivity : AppCompatActivity() {

    lateinit var buttonUpload : Button
    lateinit var buttonDownload :Button
    private val DEFAULT_IMAGE_URL = ""
    private lateinit var imageUri: Uri
    private val REQUEST_IMAGE_CAPTURE = 200
    private val currentUser = FirebaseAuth.getInstance().currentUser
    private lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonUpload = findViewById(R.id.upload)
        buttonDownload = findViewById(R.id.download)

           val storageRef = FirebaseStorage.getInstance()
            .reference.child("docs/pdf1.pdf")
        buttonDownload.setOnClickListener {

            storageRef.child("docs/pdf1.pdf").downloadUrl.addOnSuccessListener {
                // Got the download URL for 'users/me/profile.png'
            }.addOnFailureListener {
                // Handle any errors
                Toast.makeText(this, "Download failed", Toast.LENGTH_SHORT).show()

            }

//            val storageReference = FirebaseStorage.getInstance().getReferenceFromUrl("docs/pdf1.pdf/${FirebaseAuth.getInstance().currentUser?.uid}")
//            storageReference.downloadUrl.addOnSuccessListener {
//                pdfUri = it
//
//            }.addOnFailureListener {
//                Toast.makeText(requireContext(), "Download failed", Toast.LENGTH_SHORT).show()
//            }

        }
    }

}