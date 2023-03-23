package com.example.roomapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapp.data.User


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val idTxT: TextView
        val fnTxT: TextView
        val lnTxT: TextView
        val ageTxT: TextView

        init {
            idTxT = itemView.findViewById(R.id.idText)
            fnTxT = itemView.findViewById(R.id.firstNameText)
            lnTxT = itemView.findViewById(R.id.lastNameText)
            ageTxT = itemView.findViewById(R.id.ageText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.customer_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

            holder.idTxT.text = currentItem.id.toString()
            holder.fnTxT.text = currentItem.firstName
            holder.lnTxT.text = currentItem.lastName
            holder.ageTxT.text = currentItem.age.toString()

    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}