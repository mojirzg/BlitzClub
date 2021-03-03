package com.blitz



import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_test_yourself.*
import kotlinx.android.synthetic.main.layout_cycle_list_item.view.*

class TestYourself : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_yourself)
        initRecyclerView(addDataSet())

        done.setOnClickListener {
            launchActivity<TestResult>()
        }
    }

    private fun addDataSet() :List<Cycles>{
        val a = Cycles(R.drawable.run,"دویدن آهسته","","زمان:","30 ثانیه")
        val b = Cycles(R.drawable.jumping_jack,"پروانه","","زمان:","30 ثانیه")
        val c = Cycles(R.drawable.push_ups,"شنا ساده","","تعداد:","15 عدد")
        val d = Cycles(R.drawable.plank,"پلانک","","زمان:","30 ثانیه")
        val e = Cycles(R.drawable.dips_parallel,"پارالل دیپ","","نعداد:","12 عدد")
        return listOf(a,b,c,d,e)
    }

    private fun initRecyclerView(data :List<Cycles>){

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@TestYourself)
            adapter =  CylcleRecyclerAdapter(data)
        }
    }


    data class Cycles(var gif : Int,var title:String,var description:String,var unit:String,var unitCount:String)


    inline fun <reified T> launchActivity() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)

    }


   inner class CylcleRecyclerAdapter(data: List<Cycles>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
    {

        private var items: List<Cycles> = data

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return CycleViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_cycle_list_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder) {

                is CycleViewHolder -> {
                    holder.bind(items.get(position))
                }

            }
        }

        override fun getItemCount(): Int {
            return items.size
        }

        fun submitList(blogList: List<Cycles>){
            items = blogList
        }

        inner class CycleViewHolder
        constructor(
            itemView: View
        ): RecyclerView.ViewHolder(itemView){

            val cycleGif = itemView.gif
            val cycleTitle = itemView.boldTitle
            val cycleDescription = itemView.description
            val cycleUnit = itemView.unit
            val cycleUnitCount=itemView.unitCount

            fun bind(cycle: Cycles){

                Glide.with(itemView.context)
                    .load(cycle.gif)
                    .into(cycleGif)
                cycleTitle.text = cycle.title
                cycleDescription.text = cycle.description
                cycleUnit.text = cycle.unit
                cycleUnitCount.text = cycle.unitCount
                if (cycle.description=="")
                    cycleDescription.visibility= View.GONE

            }

        }

    }



}

