using System;
namespace ProductManagement.Products
{
	/// <summary>
    /// This product stock state can be used in DTO (Application.Contracts) and UI layer
    /// </summary>
	public enum ProductStockState
	{
		PreOrder,
		InStock,
		NotAvailable,
		Stopped
	}
}

