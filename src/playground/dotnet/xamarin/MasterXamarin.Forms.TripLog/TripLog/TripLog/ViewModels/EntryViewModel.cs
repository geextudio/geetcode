using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using TripLog.Models;

namespace TripLog.ViewModels
{
    /// <summary>
    /// The main purpose of the ViewModel is to separate the biz logic,
    /// for example, data access and data manipulation, from the UI logci.
    /// </summary>
    public class EntryViewModel : BaseViewModel
    {
        // https://docs.microsoft.com/zh-cn/dotnet/api/system.collections.objectmodel.observablecollection-1?view=net-5.0
        ObservableCollection<TripLogEntry> _TripLogEntries;

        /// <summary>
        /// This property is for binding to ItemsSource Property of the CollectionView element
        /// </summary>
        public ObservableCollection<TripLogEntry> TripLogEntries
        {
            get
            {
                return _TripLogEntries;
            }
            set
            {
                _TripLogEntries = value;
                OnPropertyChanged();
            }
        }

        public EntryViewModel()
        {

            TripLogEntries = new ObservableCollection<TripLogEntry>
            {
                new TripLogEntry
                {
                    Title = "Washington Monument",
                    Notes = "Amazing!",
                    Rating = 3,
                    Date = new DateTime(2019, 2, 5),
                    Latitude = 38.8895,
                    Longitude = -77.0352
                },
                new TripLogEntry
                {
                    Title = "Statue of Liberty",
                    Notes = "Inspiring!",
                    Rating = 4,
                    Date = new DateTime(2019, 4, 13),
                    Latitude = 40.6892,
                    Longitude = -74.0444
                },
                new TripLogEntry
                {
                    Title = "Golden Gate Bridge",
                    Notes = "Foggy, but beautiful.",
                    Rating = 5,
                    Date = new DateTime(2019, 4, 26),
                    Latitude = 37.8268,
                    Longitude = -122.4798
                },
                new TripLogEntry
                {
                    Title = "斜塘老街",
                    Notes = "小吃与美食在一条街上竞争.",
                    Rating = 5,
                    Date = new DateTime(2021, 4, 26),
                    Latitude = 37.8268,
                    Longitude = 122.4798
                }
            };

        }
    }
}
