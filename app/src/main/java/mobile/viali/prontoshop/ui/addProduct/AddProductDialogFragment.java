package mobile.viali.prontoshop.ui.addProduct;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobile.viali.prontoshop.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddProductDialogFragment extends Fragment {


    public AddProductDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_product_dialog, container, false);
    }

}
