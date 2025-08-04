--1
db.products.insertMany([
  { name: "Laptop", price: 1200, category: "Electronics" },
  { name: "Shoes", price: 80, category: "Fashion" },
  { name: "Book", price: 20, category: "Education" }
])

--2
db.orders.insertMany([
  {
    orderId: "ORD001",
    customerName: "John Doe",
    orderDate: new Date("2025-08-01"),
    totalAmount: 300
  },
  {
    orderId: "ORD002",
    customerName: "Jane Smith",
    orderDate: new Date("2025-08-03"),
    totalAmount: 150
  }
])

--3
db.users.insertMany([
  { name: "Alice", email: "alice@example.com", age: 30 },
  { name: "Bob", email: "bob@example.com", age: 22 },
  { name: "Charlie", email: "charlie@example.com", age: 35 },
  { name: "David", email: "david@example.com", age: 19 },
  { name: "Eva", email: "eva@example.com", age: 28 }
])

--4
db.users.find(
  { age: { $gt: 25 } },
  { _id: 0, name: 1, email: 1 }
)

--5
db.users.updateOne(
  { name: "Alice" },
  { $set: { age: 31 } }
)

--6
db.users.deleteMany(
  { age: { $lt: 20 } }
)

--7
db.users.find().sort({ age: -1 }).limit(3)

--8
db.users.find(
  {},
  { _id: 0, name: 1, age: 1 }
).sort({ age: -1 }).limit(3)

--9
db.users.aggregate([
  {
    $group: {
      _id: "$age",
      count: { $sum: 1 }
    }
  }
])

--10
db.users.aggregate([
  {
    $match: {
      age: { $gte: 25 }
    }
  },
  {
    $group: {
      _id: null,
      averageAge: { $avg: "$age" }
    }
  }
])
