package com.nilprojects.androiduidesign

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.navigation.NavigationView
import android.widget.FrameLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

import de.hdodenhof.circleimageview.CircleImageView
import android.content.DialogInterface
import android.preference.PreferenceManager
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import com.airbnb.lottie.LottieAnimationView
import com.nil.productionapp.maulifresh.CommonUtils.Configure


class ExitBottomSheetFragment: BottomSheetDialogFragment() {

    lateinit var cvCancel : CardView
    lateinit var cvExit : CardView
    lateinit var tvMobielNo : TextView
    lateinit var savedLanguagePosition : String
    var selectedLanguagePosition : Int = 0
    var listItems: Array<String>? = null
    var img = ""
    lateinit var ivProfile : CircleImageView

    var mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_exit_bottom_navigation_drawer, container, false)

        cvExit = view.findViewById<CardView>(R.id.cvExit)
        cvCancel = view.findViewById<CardView>(R.id.cvCancel)
//        ivLoading = view.findViewById<LottieAnimationView>(R.id.ivLoading)
//        ivProfile = view.findViewById<CircleImageView>(R.id.ivProfilePic)

        cvCancel.setOnClickListener {
             this.dismiss()
        }

        cvExit.setOnClickListener {
//            getActivity()!!.finish()
            ActivityCompat.finishAffinity(activity!!)
        }
//
//        tvShopName.setOnClickListener {
//            var int = Intent(activity, Profile :: class.java)
//            int.putExtra("imgUrl",img)
//            startActivity(int)
//        }


        return view
    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        disableNavigationViewScrollbars(navigation_view)
//
//    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog

            val bottomSheet = d.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet!!)
            bottomSheetBehavior.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    if (slideOffset > 0.5) {
//                        close_imageview.visibility = View.VISIBLE
                    } else {
//                        close_imageview.visibility = View.GONE
                    }
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when (newState) {
                        BottomSheetBehavior.STATE_HIDDEN-> dismiss()
//                        else -> close_imageview.visibility = View.GONE
                    }
                }
            })
        }

        return dialog
    }

//    private fun disableNavigationViewScrollbars(navigationView: NavigationView?) {
//        val navigationMenuView = navigationView?.getChildAt(0) as NavigationMenuView
//        navigationMenuView.isVerticalScrollBarEnabled = false
//    }


}