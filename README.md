##Checkout Kata

Implement the code for a supermarket checkout that calculates the total price of a number of items.
In a normal supermarket, items are identified by ‘stock keeping units’ or ‘SKUs’. In our store, we will use individual letters of the alphabet, A, B, C etc, as the SKUs. Our goods are priced individually. In addition, some items are multipriced: buy n of them and which will cost you y. For example, item A might cost 50 pence individually but this week we have a special offer where you can buy 3 As for £1.30.
This week’s prices are the following:

| Item | Unit Price | Special Price |
|------|------------|---------------|
| A    | 50         | 3 for 130     |
| B    | 30         | 2 for 45      |
| C    | 20         |               |
| D    | 15         |               |

Our checkout accepts items in any order so if we scan a B, then an A, then another B, we will recognise the two B’s and price them at 45 (for a total price so far of 95).
Extra points: Because the pricing changes frequently we will need to be able to pass in a set of pricing rules each time we start handling a checkout transaction.


#####Thoughts/Assumption(s) during 
 - No more than one offer applies to a single item
 - Error reporting has been handled by a logger which only logs out to the console. In an ideal world, I would expect that error to be fed back to the user so they know the unrecgonised item will not be added to the list of scanned items.
 i.e. When the user scans the wrong item