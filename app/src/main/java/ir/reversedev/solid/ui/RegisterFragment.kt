package ir.reversedev.solid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.reversedev.solid.R
import ir.reversedev.solid.databinding.FragmentRegisterBinding
import ir.reversedev.solid.model.DataBase
import ir.reversedev.solid.model.User
import ir.reversedev.solid.util.ErrorHandle
import ir.reversedev.solid.util.Register


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding
        get() = requireNotNull(_binding)
    private val errorHandle = ErrorHandle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentRegisterBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = DataBase.getInstance(requireContext()).dao
        val register = Register(dao)
        binding.btnRegister.setOnClickListener {
            with(binding) {
                val name = edtName.text.toString()
                val family = edtFamily.text.toString()
                val email = edtEmail.text.toString()
                val userName = edtUserName.text.toString()
                val password1 = edtPassword1.text.toString()
                val password2 = edtPassword2.text.toString()
                if (
                    name.isEmpty() &&
                    family.isEmpty() &&
                    email.isEmpty() &&
                    userName.isEmpty() &&
                    password1.isEmpty() &&
                    password2.isEmpty()
                ) {
                    Toast.makeText(context, "لطفا مقادیر را کامل وارد کنید", Toast.LENGTH_SHORT)
                        .show()
                } else if (password1 != password2) {
                    Toast.makeText(context, "لطفا رمز را شبیه به هم وارد کنید", Toast.LENGTH_SHORT)
                } else {
                    val user = User(name, family, userName, email, password1)
                    if (register.signUp(user)) {
                        findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToProfileFragment(userName))
                    } else {
                        Toast.makeText(context,errorHandle.registerError(userName,password1,name,family) , Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}