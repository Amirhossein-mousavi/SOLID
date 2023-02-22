package ir.reversedev.solid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.reversedev.solid.R
import ir.reversedev.solid.databinding.FragmentProfileBinding
import ir.reversedev.solid.model.DataBase
import ir.reversedev.solid.model.User


class ProfileFragment : Fragment() {
    private var _binding : FragmentProfileBinding? = null
    private val binding
    get() = requireNotNull(_binding)
    private val bundle by lazy {
        arguments ?: requireActivity().intent.extras
    }

    private val userName by lazy {
        bundle!!.getString("userName")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentProfileBinding.inflate(inflater , container , false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = DataBase.getInstance(requireContext()).dao
        val user = dao.getUser(userName = userName!!)
        with(binding) {
            textName.text = user.name
            textFamily.text = user.family
            textEmail.text = user.email
            textUserName.text = user.userName
            btnSignOut.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}