package com.example.salonvender.fragment


import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.salonvender.R
import com.example.salonvender.adapter.Appointment_Adapter
import com.example.salonvender.adapter.Image_Slider_Adapter
import com.example.salonvender.adapter.Mange_service_Adapter
import com.example.salonvender.adapter.Top_service_Adapter
import com.example.salonvender.databinding.FragmentHomeBinding
import com.example.salonvender.model.Banner_Model
import com.example.salonvender.model.Manage_service_model
import com.example.salonvender.model.Model_appointment_item
import com.example.salonvender.model.Top_service_Model
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations


class HomeFragment : Fragment() {
    // lateinit var toggle = ActionBarDrawerToggle

    private var list = ArrayList<Banner_Model>()
    private var list2 = ArrayList<Manage_service_model>()
    private var list3 = ArrayList<Model_appointment_item>()
    private var list4 = ArrayList<Top_service_Model>()
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var manager2: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        manager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        list.add(Banner_Model(R.drawable.banner1))
        list.add(Banner_Model(R.drawable.banner2))
        list.add(Banner_Model(R.drawable.banner3))


        // binding.imageSlider.layout = manager

        val imageSliderAdapter = Image_Slider_Adapter(requireActivity(), list)
        binding.imageSlider.setSliderAdapter(imageSliderAdapter)

        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        binding.imageSlider.startAutoCycle()

//        requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
//        if (binding.drawerLayout.isDrawerOpen()  {
//        if(binding.drawerLayout.isDrawerOpen(binding.drawerLayout)) {
//            requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
////        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//
//        }
//        else {
//            requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        }

        manager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        list2.add(Manage_service_model(R.drawable.haircut, "Haircuts"))
        list2.add(Manage_service_model(R.drawable.make_up, "Mack up"))
        list2.add(Manage_service_model(R.drawable.hairstyle, "Hairstyle"))
        list2.add(Manage_service_model(R.drawable.massage, "Massage"))
        list2.add(Manage_service_model(R.drawable.add_services, "Add Serviecs"))


        binding.recyclerManageServices.layoutManager = manager
        val adapter = Mange_service_Adapter(requireActivity(), list2)
        binding.recyclerManageServices.adapter = adapter

        manager2 = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.VERTICAL,
            false
        )


        list3.add(
            Model_appointment_item(
                R.drawable.bannty,
                "Rohan Joshi",
                "At Home",
                "Online",
                "Haircut,massag+2",
                "Male",
                "1.5",
                "Today",
                "11:00-12:00"
            )
        )
        list3.add(
            Model_appointment_item(
                R.drawable.vaidehi,
                "Vaidehi",
                "At Shop",
                "Offline",
                "Haircut,hair,massag,+1",
                "Female",
                "2.5",
                "02/12/2022",
                "11:00-12:00"
            )
        )
        list3.add(
            Model_appointment_item(
                R.drawable.prabhas,
                "Prabhas",
                "At Home",
                "Online",
                "Haircut",
                "Male",
                "1.5",
                "Today",
                "11:00-12:00"
            )
        )
        list3.add(
            Model_appointment_item(
                R.drawable.bannty,
                "Rohan Joshi",
                "At Home",
                "Online",
                "Hair spa,+2",
                "Male",
                "1.5",
                "Today",
                "12:00-12:00"
            )
        )
        list3.add(
            Model_appointment_item(
                R.drawable.bannty,
                "Rohan Joshi",
                "At Home",
                "Online",
                "Haircut,+1",
                "Male",
                "1.5",
                "Today",
                "11:00-12:00"
            )
        )

        val v = LayoutInflater.from(context)!!
            .inflate(R.layout.logout_negivation_drawer, null)
        binding.negivationView.addView(v)



        binding.appointmentRecyclerView.layoutManager = manager2

        val appointmentAdapter = Appointment_Adapter(requireActivity(), list3)
        binding.appointmentRecyclerView.adapter = appointmentAdapter



        manager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        list4.add(Top_service_Model(R.drawable.alluarjun, "Haircuts"))
        list4.add(Top_service_Model(R.drawable.bannty, "Mack up"))
        list4.add(Top_service_Model(R.drawable.vaidehi, "Hairstyle"))
        list4.add(Top_service_Model(R.drawable.prabhas, "Massage"))
        list4.add(Top_service_Model(R.drawable.bannty, "Add Serviecs"))

        binding.topServicesRecycler.layoutManager = manager
        val topServiceAdapter = Top_service_Adapter(requireActivity(), list4)
        binding.topServicesRecycler.adapter = topServiceAdapter



        binding.menu.setOnClickListener {

            binding.drawerLayout.openDrawer(GravityCompat.START)


//            requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        }


        val ColorStates = ColorStateList(
            arrayOf(
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_checked)
            ), intArrayOf(
                Color.parseColor("#4C4C4F"),
                Color.parseColor("#4C4C4F")
            )
        )
        binding.negivationView.itemTextColor = ColorStates



        binding.negivationView.itemIconTintList = ColorStates



        



        return binding.root
    }


}