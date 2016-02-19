package com.brainbox.student.dashboard_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brainbox.student.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



/**
 * Created by Admin-PC on 2/19/2016.
 */
public class MapsFragment extends Fragment
{
	private View parentView;
	static final LatLng latLang = new LatLng(28.5729 , 77.3923);
	private GoogleMap googleMap;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		parentView = inflater.inflate(R.layout.fragment_map, container, false);

		populate();

		return parentView;
	}

	private void populate(){
		try {
			if (googleMap == null) {
				googleMap = ((MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map)).getMap();
			}

			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			googleMap.addMarker(new MarkerOptions().position(latLang).title("Brain Box"));
			moveToCurrentLocation(latLang);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void moveToCurrentLocation(LatLng currentLocation)
	{
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15));
		googleMap.animateCamera(CameraUpdateFactory.zoomIn());
		googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);


	}

}
