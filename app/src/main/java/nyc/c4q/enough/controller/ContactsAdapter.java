package nyc.c4q.enough.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.enough.R;
import nyc.c4q.enough.model.Contact;

/**
 * Created by c4q on 3/4/18.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private List<Contact> contactList = new ArrayList<>();

    public ContactsAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_itemview, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        holder.contactName.setText(contactList.get(position).getContactName());
        holder.phoneText.setText(contactList.get(position).getContactNumber());
    }

    @Override
    public int getItemCount() {
        return contactList == null ? 0 : contactList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        private TextView phoneText;
        private TextView contactName;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            phoneText = itemView.findViewById(R.id.phone_contact_itemv);
            contactName = itemView.findViewById(R.id.name_contact_itemv);
        }
    }
}
