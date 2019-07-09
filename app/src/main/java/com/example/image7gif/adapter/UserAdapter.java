package com.example.image7gif.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.image7gif.R;
import com.example.image7gif.model.UserBO;
import com.example.myloadingbutton.MyLoadingButton;
import com.unstoppable.submitbuttonview.SubmitButton;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder>{

    private Context context;
    private List<UserBO> userBOList;
    int lastPosition = -1;

    public UserAdapter(Context context, List<UserBO> userBOList) {
        this.context = context;
        this.userBOList = userBOList;
    }

    @NonNull
    @Override
    public UserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_item, null);
        UserAdapterViewHolder rcv = new UserAdapterViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull final UserAdapterViewHolder holder, int position) {

        UserBO userBO = userBOList.get(position);

        holder.txtName.setText(userBO.getName());
        holder.txtAddress.setText(userBO.getAddress());
        holder.txtDescription.setText(userBO.getDescription());
        holder.imvOne.setImageResource(userBO.getImages()[position]);
        holder.imvTwo.setImageResource(userBO.getImages()[position]);
        holder.imvThree.setImageResource(userBO.getImages()[position]);
        holder.imvFour.setImageResource(userBO.getImages()[position]);

        holder.sBtnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.sBtnLoading.doResult(true);
            }
        });
//        "403 Followers, 589 Following, 904 Posts"
//        "5688 Followers, 845 Following, 1086 Posts"
//        "511 Followers, 485 Following, 452 Posts"

    }

    @Override
    public int getItemCount() {
        return userBOList.size();
    }

    public class UserAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtAddress;
        TextView txtDescription;
        ImageView imvOne;
        ImageView imvTwo;
        ImageView imvThree;
        ImageView imvFour;
        SubmitButton sBtnLoading;

        public UserAdapterViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtAddress = (TextView) itemView.findViewById(R.id.txtAddress);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            imvOne = (ImageView) itemView.findViewById(R.id.imvOne);
            imvTwo = (ImageView) itemView.findViewById(R.id.imvTwo);
            imvThree = (ImageView) itemView.findViewById(R.id.imvThree);
            imvFour = (ImageView) itemView.findViewById(R.id.imvFour);
            sBtnLoading = (SubmitButton) itemView.findViewById(R.id.sbtn_loading);
        }
    }
}
