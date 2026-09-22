const database = 'gadgetStore';
use(database);
db.dropDatabase();

//Create the collection
db.createCollection('products', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      required: ['name', 'price', 'inStock'],
      properties: {
        name: {
          bsonType: 'string',
          description: 'name must be a string and is required'
        },
        price: {
          bsonType: ['int', 'double'],
          description: 'price must be an integer or double and is required'
        },
        inStock: {
          bsonType: 'bool',
          description: 'inStock must be a boolean and is required'
        },
        specs: {
          bsonType: 'object',
          properties: {
            brand: { bsonType: 'string' }
          }
        }
      }
    }
  },
  validationLevel: 'strict',
  validationAction: 'error'
});

//Using insertMany()
db.products.insertMany([
  {
    name: 'Wireless Mouse',
    price: 29.99,
    inStock: true,
    specs: { brand: 'Logitech', connectivity: 'Bluetooth', dpi: 4000 }
  },
  {
    name: 'Mechanical Keyboard',
    price: 89.99,
    inStock: true,
    specs: { brand: 'Corsair', switches: 'Cherry MX Red', layout: 'Full-size' }
  },
  {
    name: 'Gaming Monitor',
    price: 249.99,
    inStock: false,
    specs: { brand: 'ASUS', size: '27 inch', refreshRate: '165Hz' }
  }
]);


//Using insertOne()
try {
  db.getSiblingDB('gadgetStore').products.insertOne({
  name: 'USB-C Hub',
  inStock: true,
  specs: { brand: 'Anker' }
});
} catch (err) {
  console.log('Rejected (missing price):', err.message);
}

//Using updateOne()
db.products.updateOne(
  { name: 'Wireless Mouse' },
  { $set: { category: 'Accessories' } }
);

//Using $inc
db.products.updateOne(
  { name: 'Wireless Mouse' },
  { $inc: { price: 15 } }
);

//Using $push
db.products.updateOne(
  { name: 'Wireless Mouse' },
  { $push: { tags: 'wireless' } }
);
db.products.updateOne(
  { name: 'Wireless Mouse' },
  { $push: { tags: 'bestseller' } }
);

//Using $pull
db.products.updateOne(
  { name: 'Wireless Mouse' },
  { $pull: { tags: 'wireless' } }
);

//Using $gte
console.log('Price >= 50:', db.products.find({ price: { $gte: 50 } }).toArray());

//Using dot notation
console.log('Logitech products:', db.products.find({ 'specs.brand': 'Logitech' }).toArray());

//Using $in
console.log(
  'Category in list:',
  db.products.find({ category: { $in: ['Accessories', 'Electronics'] } }).toArray()
);

//New collection orders
db.createCollection('orders');

const keyboard = db.products.findOne({ name: 'Mechanical Keyboard' });
const mouse = db.products.findOne({ name: 'Wireless Mouse' });

db.orders.insertMany([
  { productId: keyboard._id, quantity: 2 },
  { productId: mouse._id, quantity: 1 }
]);

//Using aggregate
db.orders.aggregate([
  {
    $lookup: {
      from: 'products',
      localField: 'productId',
      foreignField: '_id',
      as: 'product'
    }
  },
  { $unwind: '$product' },

  //Using $project
  {
    $project: {
      _id: 0,
      productName: '$product.name',
      quantity: 1
    }
  }
]);