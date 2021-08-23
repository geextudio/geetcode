using System;
using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace TripLog.ViewModels
{
    public class BaseViewModel : INotifyPropertyChanged 
    {
        // INotifyPropertyChanged is key to behavior & role of the ViewModel and data binding.
        // It allows a page to be notified when the properties of its ViewModel have changed.

        public BaseViewModel()
        {
        }

        public event PropertyChangedEventHandler PropertyChanged;

        protected virtual void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
