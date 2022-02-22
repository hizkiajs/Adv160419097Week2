package id.web.rpgfantasy.adv160419097w2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var num1 = (0..100).random()
        var num2 = (0..100).random()
        var res = num1 + num2
        var score = 0

        txtNum1.text = num1.toString()
        txtNum2.text = num2.toString()

        btnSubmit.setOnClickListener {
            val answer = editAnswer.text.toString()
            if (res == answer.toInt()) {
                score++
                num1 = (0..100).random()
                num2 = (0..100).random()
                res = num1 + num2

                txtNum1.text = num1.toString()
                txtNum2.text = num2.toString()
                editAnswer.setText("")
            }
            else {
                val action = MainFragmentDirections.actionGameFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}