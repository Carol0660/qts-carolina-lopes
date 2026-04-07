const express = require('express')
const app = express()
const port = 3000
const mongoose = require('mongoose')
const Person = require('./models/Person')


app.use(
  express.urlencoded({
    extended: true,
  }),
)

app.use(express.json())

app.post('/person', async (req, res) => {
  const { name, salary, approved } = req.body

  const person = {
    name,
    salary,
    approved,
  }

  try {
    await Person.create(person)

    res.status(201).json({ message: 'Pessoa inserida no sistema com sucesso!' })
  } catch (error) {
    res.status(500).json({ erro: error })
  }
})


app.get('/', (req, res) => {
  res.json({ message: 'Olá❤️' })
})

const DB_USER = 'carolina'
const DB_PASSWORD = encodeURIComponent('senha')

mongoose
.connect(
    `mongodb+srv://${DB_USER}${DB_PASSWORD}carolina:<db_password>@cluster0.sutn45z.mongodb.net/?appName=Cluster0`,
)
 .then(() => {
    console.log('Conectou ao banco!')
    app.listen(3000)
  })
  .catch((err) => console.log(err))

