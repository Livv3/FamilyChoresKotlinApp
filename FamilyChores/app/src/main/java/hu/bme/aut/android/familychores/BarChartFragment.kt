package hu.bme.aut.android.familychores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import hu.bme.aut.android.familychores.data.DataManager
import hu.bme.aut.android.familychores.databinding.FragmentBarChartBinding


class BarChartFragment : Fragment() {
    private lateinit var binding: FragmentBarChartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBarChartBinding.inflate(inflater, container, false)


        setBarChart()

        return binding.root
    }


    private fun setBarChart(){
        var names = ""
        for (i in DataManager.users.indices){
            var n = DataManager.users[i].name
            names = "$names $n"
        }

        val barEntries = ArrayList<BarEntry>()

        for(i in DataManager.users.indices){
            barEntries.add(BarEntry(i.toFloat(), DataManager.users[i].toDoList.size.toFloat() ))
        }

        val dataset = BarDataSet(barEntries, "$names")
        dataset.colors = ColorTemplate.MATERIAL_COLORS.toList()


        val data = BarData(dataset)
        binding.barChart.axisLeft.axisMinimum=0f
        binding.barChart.axisRight.axisMinimum=0f
        binding.barChart.axisLeft.axisMaximum=8f
        binding.barChart.axisRight.axisMaximum=8f
        binding.barChart.animateXY(1000, 1000)
        binding.barChart.data = data

    }


}