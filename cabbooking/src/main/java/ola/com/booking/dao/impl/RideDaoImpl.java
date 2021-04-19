package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.RideDao;
import ola.com.booking.model.Ride;

public class RideDaoImpl implements RideDao{
	
	Connection conn = ConectionManager.getConnection();

	@Override
	public void saveRide(Ride ride) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into ride(rideId,userId,routeId,dateTime) values(?,?,?,?)");
			
			stmt.setInt(1,ride.getRideId());
			stmt.setInt(2, Integer.parseInt(ride.getUserId()));
			stmt.setInt(3, Integer.parseInt(ride.getRouteId()));
			
			stmt.setString(4, "12-07-1222");
			stmt.execute();
			} catch (SQLException e)
		{
				e.printStackTrace();
				}
		}

	private static java.sql.Date getCurrentDate() {
		// TODO Auto-generated method stub
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	@Override
	public List<Ride> getRides() {
		// TODO Auto-generated method stub
		List<Ride> rideList = new ArrayList<Ride>();
		try {
			ResultSet result = conn.createStatement().executeQuery("select * from ride");
			while(result.next()) {
				Ride ride = new Ride();
				ride.setRideId(result.getInt("rideId"));
				ride.setUserId(result.getString("userId"));
				ride.setRouteId(result.getString("routeId"));
				ride.setDateTime(result.getString("dateTime"));
				
				rideList.add(ride);
				
				
			}
			return rideList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rideList;
		
		
	}
	

}
