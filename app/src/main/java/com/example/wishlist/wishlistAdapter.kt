import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.ListItem
import com.example.wishlist.R
import org.w3c.dom.Text

class wishlistAdapter(private val items: List<ListItem>) : RecyclerView.Adapter<wishlistAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //Create member variables for any view that will be set as you render a row.
        val name: TextView
        val price: TextView
        val url: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            //Store each of the layout's views into the public final member variables created above
            name = itemView.findViewById(R.id.item)
            price = itemView.findViewById(R.id.itemPrice)
            url = itemView.findViewById(R.id.shopName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = items.get(position)
        // Set item views based on views and data model
        holder.name.text = item.name
        holder.price.text = item.price
        holder.url.text = item.url
    }

    override fun getItemCount(): Int {
        return items.size
    }
}