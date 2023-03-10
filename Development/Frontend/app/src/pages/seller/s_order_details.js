import axios from 'axios'
import config from '../../config'
import { toast } from 'react-toastify'
import { useEffect, useState } from 'react'
import NavbarSeller from './../../components/seller/navbar'

const Sellerorderdetails = () => {
  const [orders, setOrders] = useState([
    {
      id: '1',
      productId: '1',
      categoryId: '1',
      sellerId: '1',
      quantity: 'Quantity1',
      date: 'Date1',
    },
    {
      id: '1',
      productId: '1',
      categoryId: '1',
      sellerId: '1',
      quantity: 'Quantity1',
      date: 'Date1',
    },
    {
      id: '1',
      productId: '1',
      categoryId: '1',
      sellerId: '1',
      quantity: 'Quantity1',
      date: 'Date1',
    },
    {
      id: '1',
      productId: '1',
      categoryId: '1',
      sellerId: '1',
      quantity: 'Quantity1',
      date: 'Date1',
    },
    {
      id: '1',
      productId: '1',
      categoryId: '1',
      sellerId: '1',
      quantity: 'Quantity1',
      date: 'Date1',
    },
  ])

  useEffect(() => {
    getOrders()
  }, [])

  const getOrders = () => {
    axios.get(config.serverURL + '/sorder', {}).then((response) => {
      const result = response.data

      if (result['status'] === 'success') {
        console.log(result)
        setOrders(result['data'])
      } else {
        toast.error(result['error'])
      }
    })
  }

  return (
    <div>
      <NavbarSeller />
      <div className='container'>
        <h3 style={styles.h3}>Order Details</h3>
        <table className='table table-striped'>
          <thead>
            <tr>
              <th>ID</th>
              <th>Product ID</th>
              <th>Seller ID</th>
              <th>Category ID</th>
              <th>Quantity</th>
              <th>Date</th>
            </tr>
          </thead>
          <tbody>
            {orders.map((order) => {
              return (
                <tr>
                  <td>{order.id}</td>
                  <td>{order.productId}</td>
                  <td>{order.sellerId}</td>
                  <td>{order.categoryId}</td>
                  <td>{order.quantity}</td>
                  <td>{order.date}</td>
                </tr>
              )
            })}
          </tbody>
        </table>
      </div>
    </div>
  )
}

const styles = {
  h3: {
    textAlign: 'center',
    margin: 20,
  },
  button: {
    marginRight: 10,
  },
}

export default Sellerorderdetails
