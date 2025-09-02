package com.example.itemtype.ui.WaitListOrders;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itemtype.R;
import com.example.itemtype.models.DateItem;
import com.example.itemtype.models.ListItem;
import com.example.itemtype.models.OrderItem;

import java.util.List;


public class OrdersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ListItem> listItems;

    public OrdersAdapter(Context context, List<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getItemViewType(int position)
    {
        return listItems.get(position).getType();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d("Debugg","In onCreate");
        if(viewType == ListItem.TYPE_DATE)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.dateitem,parent,false);
            return new DateViewHolder(view);

        }
        else if(viewType == ListItem.TYPE_ORDER)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.singleorderitem,parent,false);
            return new OrderViewHolder(view);
        }

        return null;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       try{
           Log.d("TAG", "onBindViewHolder: ");
           if (holder instanceof DateViewHolder)
           {
               DateItem dateItem = (DateItem) listItems.get(position);
               ((DateViewHolder) holder).dateText.setText(dateItem.getDate());


           } else if (holder instanceof OrderViewHolder) {
               OrderItem orderItem = (OrderItem) listItems.get(position);
               ((OrderViewHolder) holder).startTime.setText(orderItem.getOrdersDetails().getStartTime());
               ((OrderViewHolder) holder).endTime.setText(orderItem.getOrdersDetails().getEndTime());
               ((OrderViewHolder) holder).orderTitle.setText(orderItem.getOrdersDetails().getOrderTitle());
               ((OrderViewHolder) holder).customerName.setText(orderItem.getOrdersDetails().getCustomerName());
               ((OrderViewHolder) holder).statusTag.setText(orderItem.getOrdersDetails().getStatusTag());
               ((OrderViewHolder) holder).paymentTag.setText(orderItem.getOrdersDetails().getPaymentTag());

           }

       }catch (Throwable th)
       {
           Log.e("Error",""+th);
       }
    }

    @Override
    public int getItemCount() {

        return listItems.size();
    }


    static class DateViewHolder extends RecyclerView.ViewHolder{

        TextView dateText;

        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.ordersdate);
        }
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder{

        TextView startTime, endTime;
        TextView orderTitle;
        TextView customerName;
        TextView statusTag;
        TextView paymentTag;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            startTime = itemView.findViewById(R.id.StartTime);
            endTime = itemView.findViewById(R.id.EndTime);
            orderTitle = itemView.findViewById(R.id.OrderTitle);
            customerName = itemView.findViewById(R.id.CustomerName);
            statusTag = itemView.findViewById(R.id.StatusTag);
            paymentTag = itemView.findViewById(R.id.PaymentTag);

        }
    }


}
