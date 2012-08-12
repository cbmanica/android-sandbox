package org.theuntaintedsky.dailydata;

import android.app.*;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import org.theuntaintedsky.dailydata.ui.*;

/**
 * <p/>
 * <!-- insert class description here -->
 *
 * @author <a href="mailto: C. Benson Manica <benson.manica@turner.com>">C. Benson Manica</a>
 * @version $Revision: 1.0 Created 8/12/12 2:07 AM<br/> Copyright 2012 Turner Broadcasting, Inc.<br/> All
 *          rights reserved.<br/>
 */
public class EditCollectionFragment extends Fragment {
    private int collection_id;

    @Override
    public View onCreateView(LayoutInflater inflater, android.view.ViewGroup container, Bundle savedInstanceState) {
        final View ret = inflater.inflate(R.layout.ec_fragment, container, false);
        TypefaceManager.applyTypeface(getActivity().getAssets(), TypefaceManager.Types.DEFAULT,
                (TextView) ret.findViewById(R.id.ec_name_entry),
                (TextView) ret.findViewById(R.id.ec_prompt_entry),
                (TextView) ret.findViewById(R.id.ec_cancel_button),
                (TextView) ret.findViewById(R.id.ec_save_button)
        );
        return ret;
    }

    protected void setCollectionId(int collection_id) {
        this.collection_id = collection_id;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println("*** PORK I am displaying " + collection_id);
    }
}
