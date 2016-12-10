public class IsraelTour
{
	/**
	 * An array containing the trips in the company
	 */
	private Trip[] _data;
	/**
	 * Number of the trips in the company
	 */
	private int _noOfTrips;
	/**
	 * Maximum trips allowed in the company
	 */
	private final int MAX_TRIPS = 100;
	
	/**
	 * A constructor which defines the trips number to zero and constructs the array
	 */
	public IsraelTour()
	{
		_data = new Trip[MAX_TRIPS];
		this._noOfTrips = 0;
	}
	
	/**
	 * @return Trips number
	 */
	public int getNoOfTrips()
	{
		return this._noOfTrips;
	}
	
	/**
	 * Adds a given trip to the trips array
	 * @param t The trip to add
	 * @return true if the trip has been added, otherwise, returns false
	 */
	public boolean addTrip(Trip t)
	{
		if (this._noOfTrips < MAX_TRIPS)
		{
			_data[this._noOfTrips++] = new Trip(t);
			return true;
		}
		return false;
	}
	
	/**
	 * Removes a given trip from the trips array
	 * @param t The trip to remove
	 * @return true if the trip removed, otherwise, return false
	 */
	public boolean removeTrip(Trip t)
	{
		if (t != null)
		{
			for (int i = 0; i < this._noOfTrips; i++)
				if (this._data[i].equals(t))
				{
					this._data[i] = (i != this._noOfTrips - 1) ? new Trip(_data[_noOfTrips - 1]) : null;
					this._noOfTrips--;
					return true;
				}
		}
		return false;
	}

	/**
	 * Calculates the travelers number in the company
	 * @return The total travelers in the company trips
	 */
	public int howManyTravellers()
	{
		int count = 0;
		for (int i = 0; i < this._noOfTrips; i++)
			count += _data[i].getNoOfTravellers();
		return count;
	}
	
	/**
	 * Calculates how many trips have the same departure date as the date given
	 * @param d The date to compare to
	 * @return how many trips are in the given departure date
	 */
	public int howManyTripsDeparture(Date d)
	{
		int count = 0;
		for (int i = 0; i < this._noOfTrips; i++)
			count += (_data[i].getDepartureDate().equals(d)) ? 1 : 0;
		return count;
	}

	/**
	 * Calculates how many minibuses needed to all trips in a given date
	 * @param d The date to check how many minibuses needed to
	 * @return How many minibuses are needed to the given date
	 */
	public int howManyCars(Date d)
	{
		int count = 0;
		for (int i = 0; i < this._noOfTrips; i++)
			count += (this._data[i].getDepartureDate().equals(d)) ? this._data[i].howManyCars() : 0;
		return count;
	}
	
	/**
	 * @param a A Trip
	 * @param b A Trip
	 * @return The trip with the highest duration
	 */
	private Trip maxDuration(Trip a, Trip b)
	{
		return a.tripDuration() > b.tripDuration() ? new Trip(a) : new Trip(b);
	}
	
	/**
	 * @return The longest trip in the trips array
	 */
	public Trip longestTrip()
	{
		if (_data[0] != null)
		{
			Trip maxTrip = new Trip(_data[0]);
			for (int i = 1; i < _noOfTrips && _data[i] != null; i++)
				maxTrip = new Trip(maxDuration(maxTrip, _data[i]));
			return new Trip(maxTrip);
		}
		return null;
	}

	/**
	 * Checks which Guide is the most popular
	 * @return The guide's name who guides the most
	 */
	public String mostPopularGuide()
	{
		if (this._data[0] != null)
		{
			int count;
			int max = 0;
			String str = new String("");
			for (int i = 0; i < _noOfTrips; i++)
			{
				count = 1;
				for (int j = 0; j < _noOfTrips; j++)
				{
					if (i == j)
						continue;
					count += (_data[i].getGuideName().equals(_data[j].getGuideName())) ? 1 : 0;
				}
				
				if (count > max)
				{
					max = count;
					str = new String(_data[i].getGuideName());
				}
			}
			return  (!str.equals("")) ? new String(str) : null;
		}
		return null;
	}

	/**
	 * Check which departure date is the earliest
	 * @return the earliest trip departure date
	 */
	public Date earliestTrip()
	{
		if (_data[0] != null)
		{
			Date d = new Date(_data[0].getDepartureDate());
			for (int i = 1; i < _noOfTrips; i++)
				d = (_data[i].getDepartureDate().before(d)) ? new Date(_data[i].getDepartureDate()) : d;
			return new Date(d);
		}
		return null;
	}
	
	/**
	 * @return The most expensive trip
	 */
	public Trip mostExpensiveTrip()
	{
		if (_data[0] != null)
		{
			int max = 0;
			Trip t = new Trip(_data[0]);
			for (int i = 1; i < _noOfTrips; i++)
				if (_data[i].calculatePrice() > max)
				{
					t = new Trip(_data[i]);
					max = t.calculatePrice();
				}
			return new Trip(t);
		}
		return null;
	}
	

}
