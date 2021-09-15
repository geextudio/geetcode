using System;
using TripLog.Models;

namespace TripLog.ViewModels
{
    public class TripLogDetailViewModel : BaseViewModel
    {
        TripLogEntry _entry;

        public TripLogEntry Entry
        {
            get => _entry;
            set
            {
                _entry = value;
                OnPropertyChanged();
            }
        }

        public TripLogDetailViewModel(TripLogEntry entryItem)
        {
            Entry = entryItem;
        }


    }
}
