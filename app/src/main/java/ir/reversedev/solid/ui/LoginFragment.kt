package ir.reversedev.solid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.reversedev.solid.R
import ir.reversedev.solid.databinding.FragmentLoginBinding
import ir.reversedev.solid.model.DataBase
import ir.reversedev.solid.util.AuthenticationRoom
import ir.reversedev.solid.util.Login
import ir.reversedev.solid.util.NewErrorHandle


class LoginFragment() : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding
        get() = requireNotNull(_binding) { "this is never null" }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLoginBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = DataBase.getInstance(requireContext()).dao
        val login= Login(AuthenticationRoom(dao) , NewErrorHandle())
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnLogin.setOnClickListener {
            val userName = binding.edtUserName.text.toString()
            val password = binding.edtPassword.text.toString()
            if (userName.isEmpty()&& password.isEmpty()) {
                Toast.makeText(context, "مقادیر را کامل وارد کنید", Toast.LENGTH_SHORT).show()
            } else {
                if (login.login(userName , password).second) {
                Toast.makeText(context, login.login(userName , password).first , Toast.LENGTH_SHORT).show()
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToProfileFragment(userName))
                } else {
                    Toast.makeText(context, login.login(userName , password).first , Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}