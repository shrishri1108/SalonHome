package com.example.salonvender.fragment


import android.app.Activity
import android.app.DatePickerDialog
import android.app.appsearch.AppSearchResult.RESULT_OK
import android.content.ContentValues.TAG
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.opengl.Visibility
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageView
import com.example.salonvender.GetFileFromUriUsingBufferReader
import com.example.salonvender.R
import com.example.salonvender.activity.App
import com.example.salonvender.activity.HomeActivity
import com.example.salonvender.model.LoginViewModel
import com.example.salonvender.singalton_object.PrefManager
import com.github.dhaval2404.imagepicker.ImagePicker
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


class Fill_Profile : Fragment() {

    var Cancel_Check_File: File? = null
    var License_File: File? = null
    var ID_File: File? = null
    var Prof_IMG_FILE: File? = null
    private var is_License_Upload_Dialog_Active: Boolean = false
    private var is_ID_Proof_Dialog_Active: Boolean = false
    private var is_Cancel_checkDialog_Active: Boolean = false
    private var ID_REQ_CODE: Int? = null
    lateinit var viewModel: LoginViewModel
    lateinit var pattern: Pattern
    lateinit var matcher: Matcher
    var EMAIL_PATTERN: String =
        "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private var datePickerDialog: DatePickerDialog? = null
    lateinit var datepickerDialog: DatePickerDialog
    lateinit var binding: com.example.salonvender.databinding.FragmentFillProfileBinding
    var PROFILE_IMG_UPLOAD_REQ_CODE: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_fill__profile, container, false)


        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.lifecycleOwner = this




        fun isEmpty(enter: AppCompatEditText): Boolean {

            val str: CharSequence = binding.name.text.toString()
            return TextUtils.isEmpty(str)


        }

        val phone = requireArguments().getString("phone").toString()
        binding.phoneNo.text = phone

        fun isEmpty2(enter: AppCompatTextView): Boolean {

            val str2: CharSequence = binding.dob.text.toString()
            return TextUtils.isEmpty(str2)


        }


        binding.back.setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, Create_your_Account()).commit()
        }


//        Log.d("token", PrefManager.getInstance(App.getInstance())!!.userDetail.token)


        binding.genderCard.setOnClickListener {


            if (binding.genderItemCard.visibility == View.VISIBLE) {
                binding.genderItemCard.visibility = View.GONE

                binding.male.setOnClickListener {
                    binding.Gender.text = binding.male.text.toString()
                    if (binding.genderItemCard.visibility == View.VISIBLE) {
                        binding.genderItemCard.visibility = View.GONE
                    }

                }

                binding.female.setOnClickListener {
                    binding.Gender.text = binding.female.text.toString()
                    if (binding.genderItemCard.visibility == View.VISIBLE) {
                        binding.genderItemCard.visibility = View.GONE
                    }
                }


            } else {
                binding.genderItemCard.visibility = View.VISIBLE
                binding.male.setOnClickListener {
                    binding.Gender.text = binding.male.text.toString()
                    if (binding.genderItemCard.visibility == View.VISIBLE) {
                        binding.genderItemCard.visibility = View.GONE
                    }

                }

                binding.female.setOnClickListener {
                    binding.Gender.text = binding.female.text.toString()
                    if (binding.genderItemCard.visibility == View.VISIBLE) {
                        binding.genderItemCard.visibility = View.GONE
                    }
                }


            }


        }

        binding.profileImg.setOnClickListener {

            PROFILE_IMG_UPLOAD_REQ_CODE = 1;
            ImagePicker.with(this@Fill_Profile)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                )    //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
//           val gallery =
//                Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
//            startActivityForResult(gallery, 2)
//             val cropImage = registerForActivityResult(CropImageContract()) { result ->
//                if (result.isSuccessful) {
//                    // Use the returned uri.
//                    val uriContent = result.uriContent
//                    val uriFilePath = result.getUriFilePath(requireContext()) // optional usage
//                    Prof_IMG_FILE= File(uriFilePath.toString())
//                } else {
//                    // An error occurred.
//                    val exception = result.error
//                }
//            }
//            Prof_IMG_FILE= File(cropImage)
        }

        binding.editProfileBtn.setOnClickListener {

            PROFILE_IMG_UPLOAD_REQ_CODE = 1;
            ImagePicker.with(this@Fill_Profile)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                )   //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
//           val gallery =
//                Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
//            startActivityForResult(gallery, 2)
//             val cropImage = registerForActivityResult(CropImageContract()) { result ->
//                if (result.isSuccessful) {
//                    // Use the returned uri.
//                    val uriContent = result.uriContent
//                    val uriFilePath = result.getUriFilePath(requireContext()) // optional usage
//                    Prof_IMG_FILE= File(uriFilePath.toString())
//                } else {
//                    // An error occurred.
//                    val exception = result.error
//                }
//            }
//            Prof_IMG_FILE= File(cropImage)
        }

        binding.cardIDProof.setOnClickListener {
            is_ID_Proof_Dialog_Active = true
//            ID_REQ_CODE = 2;
//            AlertDialogInActive()

//            ImagePicker.with(this)
//                .crop()                    //Crop image(Optional), Check Customization for more option
//                .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                .maxResultSize(
//                    1080,
//                    1080
//                )    //Final image resolution will be less than 1080 x 1080(Optional)
//                .start()

            ImagePicker.with(this@Fill_Profile)
                .crop() //Crop image(Optional), Check Customization for more option
                .compress(1024) //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                ) //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }

        binding.cardUploadLicence.setOnClickListener {
            is_License_Upload_Dialog_Active = true
//            ID_REQ_CODE = 3
//            AlertDialogInActive()
//            //                                             File image=
//            //                                             CropImage.activity(null).setGuidelines(CropImageView.Guidelines.ON).start(ReportDetailsActivity.this);
            ImagePicker.with(this@Fill_Profile)
                .crop() //Crop image(Optional), Check Customization for more option
                .compress(1024) //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                ) //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }
        binding.salonCard.setOnClickListener {


            if (binding.salonCardItem.visibility == View.VISIBLE) {
                binding.salonCardItem.visibility = View.GONE

                binding.salon.setOnClickListener {
                    binding.salonMain.text = binding.salon.text.toString()
                    if (binding.salonCardItem.visibility == View.VISIBLE) {
                        binding.salonCardItem.visibility = View.GONE

//                        if (binding.salon == binding.FREEESTILO) {
//                            binding.shopNameCard.visibility = View.GONE
//                            binding.locationCard.visibility = View.GONE
//                        }

                    }
                    binding.shopNameCard.visibility = View.VISIBLE

                }

                binding.freeLancher.setOnClickListener {
                    binding.salonMain.text = binding.freeLancher.text.toString()
                    if (binding.salonCardItem.visibility == View.VISIBLE) {
                        binding.salonCardItem.visibility = View.GONE

//                        if (binding.salon == binding.FREEESTILO) {
//                            binding.locationCard.visibility = View.GONE
//                        }

                    }
                    binding.shopNameCard.visibility = View.GONE


                }

            } else {
                binding.salonCardItem.visibility = View.VISIBLE
                binding.salon.setOnClickListener {
                    binding.salonMain.text = binding.salon.text.toString()
                    if (binding.salonCardItem.visibility == View.VISIBLE) {
                        binding.salonCardItem.visibility = View.GONE

//                        if (binding.salon == binding.FREEESTILO) {
//                            binding.shopNameCard.visibility = View.GONE
//                            binding.locationCard.visibility = View.GONE
//                        }
                    }
                    binding.shopNameCard.visibility = View.VISIBLE

                }
                binding.freeLancher.setOnClickListener {
                    binding.salonMain.text = binding.freeLancher.text.toString()
                    if (binding.salonCardItem.visibility == View.VISIBLE) {
                        binding.salonCardItem.visibility = View.GONE

//                        if (binding.salon == binding.FREEESTILO) {
//                            binding.locationCard.visibility = View.GONE
//                        }
                    }
                    binding.shopNameCard.visibility = View.GONE

                }
            }
        }

        binding.cancelCheck.setOnClickListener {
            is_Cancel_checkDialog_Active = true
//            ID_REQ_CODE = 3
//            AlertDialogInActive()
//            //                                             File image=
//            //                                             CropImage.activity(null).setGuidelines(CropImageView.Guidelines.ON).start(ReportDetailsActivity.this);
            ImagePicker.with(this@Fill_Profile)
                .crop() //Crop image(Optional), Check Customization for more option
                .compress(1024) //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                ) //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }
//            if(binding.salon==binding.FREEESTILO){
//
//                binding.shopNameCard.visibility = View.GONE
//                binding.locationCard.visibility=View.GONE
//
//            }

        binding.GenderCustomerCard.setOnClickListener {


            if (binding.genderCustomerItemCard.visibility == View.VISIBLE) {
                binding.genderCustomerItemCard.visibility = View.GONE

                binding.customerMale.setOnClickListener {
                    binding.GenderCustomer.text =
                        binding.customerMale.text.toString()
                    if (binding.genderCustomerItemCard.visibility == View.VISIBLE) {
                        binding.genderCustomerItemCard.visibility = View.GONE
                    }

                }

                binding.customerFemale.setOnClickListener {
                    binding.GenderCustomer.text =
                        binding.customerFemale.text.toString()
                    if (binding.genderCustomerItemCard.visibility == View.VISIBLE) {
                        binding.genderCustomerItemCard.visibility = View.GONE
                    }
                }

                binding.transGender.setOnClickListener {
                    binding.GenderCustomer.text =
                        binding.transGender.text.toString()
                    if (binding.genderCustomerItemCard.visibility == View.VISIBLE) {
                        binding.genderCustomerItemCard.visibility = View.GONE
                    }
                }


            } else {
                binding.genderCustomerItemCard.visibility = View.VISIBLE
                binding.customerMale.setOnClickListener {
                    binding.GenderCustomer.text =
                        binding.customerMale.text.toString()
                    if (binding.genderCustomerItemCard.visibility == View.VISIBLE) {
                        binding.genderCustomerItemCard.visibility = View.GONE
                    }

                }

                binding.customerFemale.setOnClickListener {
                    binding.GenderCustomer.text =
                        binding.customerFemale.text.toString()
                    if (binding.genderCustomerItemCard.visibility == View.VISIBLE) {
                        binding.genderCustomerItemCard.visibility = View.GONE
                    }
                }

                binding.transGender.setOnClickListener {
                    binding.GenderCustomer.text =
                        binding.transGender.text.toString()
                    if (binding.genderCustomerItemCard.visibility == View.VISIBLE) {
                        binding.genderCustomerItemCard.visibility = View.GONE
                    }
                }


            }


        }



        binding.submit.setOnClickListener {

            binding.progressBar.visibility = View.VISIBLE
//            if (isEmpty()) {
//
//                Toast.makeText(activity, "please fill mobile number", Toast.LENGTH_SHORT).show()
//                binding.phoneNo.error = "please fill mobile number"
//
//            } else {
//
//                binding.phoneNo.length() == 10
//
//            }

            if (isEmpty(binding.name)) {

                binding.name.error = "Please fill name"
                binding.name.requestFocus()
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty2(binding.dob)) {
                binding.dob.error = "Please fill dob"
                binding.progressBar.visibility = View.GONE
                binding.dob.requestFocus()

            } else if (isEmpty2(binding.Gender)) {

                binding.Gender.error = "Please select Gender"
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty2(binding.salon)) {
                binding.salon.error = "Please select Vendor Type"
                binding.name.requestFocus()
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty(binding.shopName)) {

                binding.shopName.error = "Please fill shop name"
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty(binding.email)) {

                binding.email.error = "Select your email id"
                binding.progressBar.visibility = View.GONE
            } else if (!isEmpty(binding.email)) {

                pattern = Pattern.compile(EMAIL_PATTERN);
                matcher = pattern.matcher(binding.email.toString());
                binding.progressBar.visibility = View.GONE

            } else if (isEmpty(binding.location)) {

                binding.location.error = "Please fill location"
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty2(binding.UploadIDProof)) {

                binding.UploadIDProof.error = "Please select id proof"
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty2(binding.UploadLicense)) {
                binding.UploadLicense.error = "Please select License"
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty(binding.BankName)) {

                binding.BankName.error = "Please enter the Bank Name"
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty(binding.AccountHolderName)) {

                binding.AccountHolderName.error = "Please enter Account Holder Name"
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty(binding.AccountNo)) {

                binding.AccountNo.error = "Enter Account no"
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty(binding.ifscCode)) {

                binding.ifscCode.error = "Enter ifsc code"
                binding.progressBar.visibility = View.GONE
            } else if (isEmpty2(binding.GenderCustomer)) {

                binding.GenderCustomer.error = "Please select customer's gender"
                binding.progressBar.visibility = View.GONE
            }

//            if (isEmpty(binding.password)) {
//
//                binding.password.error = "create password"
//            }
//
//            if (Cancel_Check_File == null) {
//
//                binding.cancelCheck.error = " Cancel Check is required."
//            }


//            if (Prof_IMG_FILE == null) {
//
//                Toast.makeText(context, " Profile image is required", Toast.LENGTH_SHORT).show()
//            }
//
//            if (ID_File == null) {
//
//                binding.UploadIDProof.error = " ID Proof is required"
//
//            }
//
//            if (License_File == null) {
//                binding.UploadLicense.error = "License is not Uploaded. "
//            }
//
//            if (isEmpty(binding.conformPassword)) {
//
//                binding.conformPassword.error = "confirm password"
//            }


            else if (!binding.termAndCondition.isChecked) {

                Toast.makeText(
                    requireActivity(),
                    "Please accept terms and conditions ",
                    Toast.LENGTH_SHORT
                ).show()

                binding.progressBar.visibility = View.GONE
                return@setOnClickListener
            }

            //            val hashmap = HashMap<String, String>()


            // val loginFragment = LoginFragment()
//
//                val intent = Intent(activity, HomeActivity::class.java)
//                        startActivity(intent)
//                        (activity as Activity).overridePendingTransition(0, 0)

//
//            hashmap["email"] = binding.email.text.toString()
//            hashmap["name"] = binding.name.text.toString()
//            hashmap["phone"] = binding.phoneNo.text.toString()
//            hashmap["gender"] = binding.Gender.text.toString()
//            hashmap["dob"] = binding.dob.text.toString()
//            hashmap["vendor_type"] = "Salon"
//            hashmap["bank_name"] = binding.BankName.text.toString()
//            hashmap["account_holder_name"] = binding.AccountHolderName.toString()
//            hashmap["account_no"] = binding.AccountNo.text.toString()
//            hashmap["ifsc_code"] = binding.ifscCode.text.toString()
//

//
//            Toast.makeText(
//                activity,
//                PrefManager.getInstance(App.getInstance())!!.userDetail.token,
//                Toast.LENGTH_SHORT
//            ).show()

            fun getRequestBody(str: String?): RequestBody =
                str.toString().toRequestBody("text/plain".toMediaTypeOrNull())

//
//            var thumbnailBody: RequestBody? = null
//            if (ID_File != null)
//                thumbnailBody = ID_File?.asRequestBody("image/*".toMediaTypeOrNull())
//            val ID_Path_part_val: MultipartBody.Part = MultipartBody.Part.Companion.createFormData(
//                "id_proof_image", ID_File!!.name,
//                thumbnailBody!!
//            )
//            var LicenceBody: RequestBody? = null
//            if (License_File != null)
//                LicenceBody = License_File?.asRequestBody("image/*".toMediaTypeOrNull())
//            val Licence_part_val: MultipartBody.Part = MultipartBody.Part.Companion.createFormData(
//                "licence_image",
//                License_File!!.name,
//                LicenceBody!!
//            )
//            var Cancel_CheckBody: RequestBody? = null
//            if (Cancel_Check_File != null)
//                Cancel_CheckBody =
//                    Cancel_Check_File?.asRequestBody("image/*".toMediaTypeOrNull())
//            val cancel_check_part_val: MultipartBody.Part =
//                MultipartBody.Part.Companion.createFormData(
//                    "check_image",
//                    Cancel_Check_File!!.name,
//                    Cancel_CheckBody!!
//                )
//            var userImage_Body: RequestBody? = null
//            if (Prof_IMG_FILE != null)
//                userImage_Body =
//                    Prof_IMG_FILE?.asRequestBody("image/*".toMediaTypeOrNull())
//            val user_Image_part_val: MultipartBody.Part =
//                MultipartBody.Part.Companion.createFormData(
//                    "user_image",
//                    Prof_IMG_FILE!!.name,
//                    userImage_Body!!
//                )
//            Log.d("token", PrefManager.getInstance(App.getInstance())!!.userDetail.token)

            viewModel.upload(
                getRequestBody(binding.email.text.toString()),
                getRequestBody(binding.name.text.toString()),
//                getRequestBody("Vndor1"),
                getRequestBody(binding.phoneNo.text.toString()),
//                getRequestBody("7706064510"),
                getRequestBody(binding.Gender.text.toString()),
                getRequestBody(binding.dob.text.toString()),
                getRequestBody(if(binding.salonMain.text.toString().equals("Door Buddy"))"freelancer" else "salon"),
//                getRequestBody("salon"),
                getRequestBody(binding.BankName.text.toString()),
//                cancel_check_part_val,
                // getRequestBody(Cancel_Check_File?.path.toString()),
                getRequestBody(binding.location.text.toString()),
//                getRequestBody(Prof_IMG_FILE?.path.toString()),
//                user_Image_part_val,
//                ID_Path_part_val,
                getRequestBody(binding.AccountHolderName.text.toString()),
                // getRequestBody(License_File?.path.toString()),
//                Licence_part_val,
                getRequestBody(binding.AccountNo.text.toString()),
                getRequestBody(binding.GenderCustomer.text.toString()),
//                getRequestBody("mens"),
                getRequestBody(binding.ifscCode.text.toString())

            ).observe(viewLifecycleOwner, Observer { it ->

//                Toast.makeText(requireActivity(), "go go", Toast.LENGTH_SHORT).show()
//
//                Toast.makeText(requireContext(), "Go Go GO", Toast.LENGTH_SHORT).show()


                if (it.result == true) {

                    Toast.makeText(
                        requireActivity(),
                        "Your details has been submitted. Pending for approval.  ",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("apiht", "onCreateView: res")
                    val intent = Intent(activity, HomeActivity::class.java)
                    startActivity(intent)
                    (activity as Activity).overridePendingTransition(0, 0)
                    binding.progressBar.visibility = View.GONE
                } else {
                    Toast.makeText(
                        requireContext(),
                        " " + it.message + " -------> " + it.result,
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d(
                        "apiht",
                        "onCreateView:results " + it.message + " -------> " + it.result
                    )
                    binding.progressBar.visibility = View.GONE
                }

            })
        }
        binding.dobCard.setOnClickListener {
            val formatDate = SimpleDateFormat("YYYY/MM/dd", Locale.US)
            val cal = Calendar.getInstance()
            val dataPicDialog = DatePickerDialog(
                requireContext(),
                R.style.DialogTheme,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, i)
                    selectDate.set(Calendar.MONTH, i2)
                    selectDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date = formatDate.format(selectDate.time)
                    binding.dob.text = date
                },
                cal[Calendar.YEAR],
                cal[Calendar.MONTH],
                cal[Calendar.DAY_OF_MONTH]
            )
            dataPicDialog.show()
            dataPicDialog.datePicker.maxDate = cal.timeInMillis
//            dataPicDialog.datePicker.maxDate();
        }

        return binding.root
    }

    private fun getTodaysDate(): String? {
        val cal = Calendar.getInstance()
        val year = cal[Calendar.YEAR]
        var month = cal[Calendar.MONTH]
        month += 1
        val day = cal[Calendar.DAY_OF_MONTH]
        return makeDateString(year, month, day)
    }


    private fun makeDateString(year: Int, month: Int, day: Int): String? {
        return getMonthFormat(year) + "/" + month + "/" + day
    }

    private fun getMonthFormat(month: Int): String {
        if (month == 1) return "01"
        if (month == 2) return "02"
        if (month == 3) return "03"
        if (month == 4) return "04"
        if (month == 5) return "05"
        if (month == 6) return "06"
        if (month == 7) return "07"
        if (month == 8) return "08"
        if (month == 9) return "09"
        if (month == 10) return "10"
        if (month == 11) return "11"
        return if (month == 12) "12" else "01"

        //default should never happen
    }


    fun AlertDialogInActive() {
//        Toast.makeText( context, " Clickesed . ", Toast.LENGTH_SHORT).show()
        val builder = androidx.appcompat.app.AlertDialog.Builder(requireContext())
        val view: View = LayoutInflater.from(requireContext())
            .inflate(R.layout.layout_upload, null, false)
        builder.setView(view)
//        val text = view.findViewById<TextView>(R.id.tv_text_)
        val btn_cancel = view.findViewById<Button>(R.id.btn_cancel)
//        val btn_pdf = view.findViewById<Button>(R.id.btn_pdf)
        val btn_image = view.findViewById<Button>(R.id.btn_image)
        val alert = builder.create()
        btn_cancel.setOnClickListener {
            ID_REQ_CODE = 0
            alert.dismiss()
        }
//        btn_pdf.setOnClickListener {
//            alert.dismiss()
//            //                Intent intent = new Intent();
//            //                intent.setType("application/pdf");
//            //                intent.setAction(Intent.ACTION_GET_CONTENT);
//            //                startActivityForResult(intent,  SELECT_VIDEO);
//
//            ID_REQ_CODE = 1
//            val pdfIntent = Intent()
//            pdfIntent.type = "application/pdf"
//            pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
//            pdfIntent.action = Intent.ACTION_GET_CONTENT
//            startActivityForResult(pdfIntent, 13)
//
//            /*Intent intent
//                             = new Intent(Intent.ACTION_GET_CONTENT);
//                     // set type
//                     intent.setType("application/pdf");
//                     // Launch intent
//                     resultLauncher.launch(intent);*/
//        }
        btn_image.setOnClickListener {
            alert.dismiss()
            //                                             File image=
            //                                             CropImage.activity(null).setGuidelines(CropImageView.Guidelines.ON).start(ReportDetailsActivity.this);
            ImagePicker.with(this@Fill_Profile)
                .crop() //Crop image(Optional), Check Customization for more option
                .compress(1024) //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                ) //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }

//        alert.setTitle("Redeem Request Status");
        alert.show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (PROFILE_IMG_UPLOAD_REQ_CODE == 1) {
            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
//                val imageUriTOFile = File(data!!.data.toString())
//                Toast.makeText(this, " " + imageUriTOFile.absolutePath, Toast.LENGTH_SHORT).show()
//                etFile.setText(imageUriTOFile.name.toString())
//                val uri: Uri? = data!!.data

//                var selectedImageUri = data?.data
//                val  path: String =getPathFromURI(selectedImageUri)
//                if (path != null) {
//                    Prof_IMG_FILE = File(path)
//                    selectedImageUri = Uri.fromFile(Prof_IMG_FILE)
//                }
//                Prof_IMG_FILE = File(data?.getData().toString());
//                if (Prof_IMG_FILE == null)
                Prof_IMG_FILE = GetFileFromUriUsingBufferReader().getImageFile(
                    requireContext().applicationContext,
                    data?.data
                )
//                Prof_IMG_FILE = GetFileFromUriUsingBufferReader().getImageFile(
//                    requireContext(),
//                    uri
//                )
//                Toast.makeText(context, ""+ Prof_IMG_FILE!!.name +" :-> "+Prof_IMG_FILE!!.path, Toast.LENGTH_SHORT).show()
                // Use Uri object instead of File to avoid storage permissions
                binding.profileImg.setImageURI(Uri.parse(Prof_IMG_FILE!!.path))
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()

            }
        } else if (is_ID_Proof_Dialog_Active) {
            if (resultCode == Activity.RESULT_OK) {
//                    ID_File = GetFileFromUriUsingBufferReader().getImageFile(requireContext(), data!!.data)
//                  Toast.makeText(context, " " + data!!.data, Toast.LENGTH_SHORT).show()
                Log.d(TAG, "myErrorsTest " + (resultCode == RESULT_OK))

                // Get the Uri of the selected file
//                    val uri = data?.data
//                    val uriString = uri.toString()
//                ID_File = File(data?.getData().toString());
//                if (ID_File == null)
                ID_File =
                    GetFileFromUriUsingBufferReader().getImageFile(
                        requireContext().applicationContext,
                        data?.data
                    )
//                    var displayName: String? = null
//
//                    Log.d(TAG, "onActivityResult: " + uriString)
//                    if (uriString.startsWith("content://")) {
//                        var cursor: Cursor? = null
//                        try {
//                            cursor = context?.contentResolver?.query(uri!!, null, null, null, null)
//                            if (cursor != null && cursor.moveToFirst()) {
//                                displayName =
//                                    cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
//                            }
//                        } finally {
//                            cursor!!.close()
//                        }
//                    } else if (uriString.startsWith("file://")) {
//                        displayName = ID_File!!.name
//                    }
//                    binding.UploadIDProof.text = ""
//                    Log.d("aksjdhasd", ID_File!!.path)
////                    Log.d("aksjdhasd",new Docuuuu().getFile(this,uri).getPath());
//
//
//                    Toast.makeText(
//                        context,
//                        "" + ID_File!!.name + " :-> " + ID_File!!.path,
//                        Toast.LENGTH_SHORT
//                    ).show()
////                    Log.d("aksjdhasd", new Docuuuu ().getFile(this, uri).getPath());
                binding.UploadIDProof.text = ID_File!!.name.toString() + ""
////                    uploadPdf()

            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()

            }
            is_ID_Proof_Dialog_Active = false
        } else if (is_License_Upload_Dialog_Active) {

            if (resultCode == Activity.RESULT_OK) {
//                    Toast.makeText(context, " " + data!!.data, Toast.LENGTH_SHORT).show()
//                    Log.d(TAG, "myErrorsTest " + (resultCode == RESULT_OK))
//                    // Get the Uri of the selected file
//                    val uri = data?.data
//                    val uriString = uri.toString()
//                    License_File = File(uriString)
//                    var displayName: String? = null
//
//                    Log.d(TAG, "onActivityResult: " + uriString)
//                    if (uriString.startsWith("content://")) {
//                        var cursor: Cursor? = null
//                        try {
//                            cursor = context?.contentResolver?.query(uri!!, null, null, null, null)
//                            if (cursor != null && cursor.moveToFirst()) {
//                                displayName =
//                                    cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
//                            }
//                        } finally {
//                            cursor!!.close()
//                        }
//                    } else if (uriString.startsWith("file://")) {
//                        displayName = License_File!!.name
//                    }
//                    binding.UploadLicense.text = ""
//                License_File = File(data?.getData().toString());
//                if (License_File == null)
//                    Log.d("aksjdhasd", License_File!!.path)
////                    Log.d("aksjdhasd",new Docuuuu().getFile(this,uri).getPath());
                License_File = GetFileFromUriUsingBufferReader().getImageFile(
                    requireContext().applicationContext,
                    data?.data
                )
//
////                Toast.makeText(context, ""+ License_File!!.name +" :-> "+License_File!!.path, Toast.LENGTH_SHORT).show()
//                    //                    Log.d("aksjdhasd",new Docuuuu().getFile(this,uri).getPath());
                binding.UploadLicense.text = License_File?.name + ""

//                uploadPdf(GetFileFromUriUsingBufferReader().getFile(this, uri!!))

            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()

            }
            is_License_Upload_Dialog_Active = false
//            ID_REQ_CODE = 0
        } else if (is_Cancel_checkDialog_Active) {
            if (resultCode == Activity.RESULT_OK) {
//                 Toast.makeText(context, " " + data!!.data, Toast.LENGTH_SHORT).show()
//                 Log.d(TAG, "myErrorsTest " + (resultCode == RESULT_OK))
//                 /*    if (data!=null && data.getData()!=null){
//                try {
//                    Log.d("akjshdasd", PathUtil.getPath(this,data.getData()));
//                } catch (URISyntaxException e) {
//                    e.printStackTrace();
//                }
//            }*/
//
//                 // Get the Uri of the selected file
//                 val uri = data?.data
//                 val uriString = uri.toString()
//                 Cancel_Check_File = File(uriString)
//                 var displayName: String? = null
//
//                 Log.d(TAG, "onActivityResult: " + uriString)
//                 if (uriString.startsWith("content://")) {
//                     var cursor: Cursor? = null
//                     try {
//                         cursor = context?.contentResolver?.query(uri!!, null, null, null, null)
//                         if (cursor != null && cursor.moveToFirst()) {
//                             displayName =
//                                 cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
//                         }
//                     } finally {
//                         cursor!!.close()
//                     }
//                 } else if (uriString.startsWith("file://")) {
//                     displayName = Cancel_Check_File!!.name
//                 }
//                 binding.cancelCheck.text = ""
//                 Log.d("aksjdhasd", Cancel_Check_File!!.path)
////                    Log.d("aksjdhasd",new Docuuuu().getFile(this,uri).getPath());
//
//
//                 //                    Log.d("aksjdhasd",new Docuuuu().getFile(this,uri).getPath());
//                 binding.cancelCheck.text = displayName.toString() + ""
//
//                 Toast.makeText(
//                     context,
//                     "" + Cancel_Check_File!!.name + " :-> " + Cancel_Check_File!!.path,
//                     Toast.LENGTH_SHORT
//                 ).show()
//                uploadPdf(GetFileFromUriUsingBufferReader().getFile(this, uri!!))


                /*    if (data!=null && data.getData()!=null){
            try {
                Log.d("akjshdasd", PathUtil.getPath(this,data.getData()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }*/
//
//                    // Get the Uri of the selected file
//                    val uri = data!!.data
//                    val uriString = uri.toString()
//                    Cancel_Check_File = File(uriString)
//                    var displayName: String? = null
//
//                    if (uriString.startsWith("content://")) {
//                        var cursor: Cursor? = null
//                        try {
//                            cursor =
//                                this.context!!.contentResolver.query(uri!!, null, null, null, null)
//                            if (cursor != null && cursor.moveToFirst()) {
//                                displayName =
//                                    cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
//                            }
//                        } finally {
//                            cursor!!.close()
//                        }
//                    } else if (uriString.startsWith("file://")) {
//                        displayName = Cancel_Check_File!!.name
//                    }
//                    binding.cancelCheck.text = " "
//                    Log.d("aksjdhasd", Cancel_Check_File!!.path)
////                    Log.d("aksjdhasd",new Docuuuu().getFile(this,uri).getPath());
//
//
//                    //                    Log.d("aksjdhasd",new Docuuuu().getFile(this,uri).getPath());
//                var selectedImageUri = data?.data
//                val path: String = getPathFromURI(selectedImageUri)
//                if (path != null) {
//                    Cancel_Check_File = File(path)
//                    selectedImageUri = Uri.fromFile(Prof_IMG_FILE)
//                }
//                if(Cancel_Check_File == null)
//                val file: File  = File(data?.data.toString());
//                Cancel_Check_File= File(file.name)
//                if (Cancel_Check_File == null)
//                Cancel_Check_File =
//                    GetFileFromUriUsingBufferReader().getImageFile(
//                        requireContext().applicationContext,
//                        data?.data
//                    )
                Cancel_Check_File =
                    GetFileFromUriUsingBufferReader().getImageFile(
                        requireContext().applicationContext,
                        data?.data
                    )
////                 uploadPdf(GetFileFromUriUsingBufferReader().getFile(this, uri!!))

                binding.cancelCheck.text = Cancel_Check_File?.name.toString()
//
//                } else if (resultCode == ImagePicker.RESULT_ERROR) {
//                    Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT)
//                        .show()
//                } else {
//                    Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
//
//                }
//         else if (ID_REQ_CODE == 1) {
//            if (resultCode == Activity.RESULT_OK) {
//                binding.cancelCheck.text = ""
//
//                Cancel_Check_File = GetFileFromUriUsingBufferReader().getFile(
//                    requireContext(),
//                    data?.data
//                )
//
//                    Toast.makeText(context, ""+ Cancel_Check_File!!.name +" :-> "+Cancel_Check_File!!.path, Toast.LENGTH_SHORT).show()
//                binding.cancelCheck.text = Cancel_Check_File?.name.toString()
////                AddImage(GetFileFromUriUsingBufferReader().getImageFile(this, data.data!!))
//            } else if (resultCode == ImagePicker.RESULT_ERROR) {
//                Toast.makeText(context, "" + ImagePicker.getError(data), Toast.LENGTH_SHORT)
//                    .show()
//            } else {
//                Toast.makeText(context, " Action Cancelled .", Toast.LENGTH_SHORT).show()
//            }
//        }
//        ID_REQ_CODE = 0
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()

            }
            is_Cancel_checkDialog_Active = false
        }
    }


    private fun getPathFromURI(selectedImageUri: Uri?): String {
        var res: String? = null

        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor: Cursor? =
            this.context?.contentResolver?.query(selectedImageUri!!, proj, null, null, null)
        if (cursor!!.moveToFirst()) {
            val column_index: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            res = cursor.getString(column_index)
        }
        cursor.close()
        return res!!
    }
}



