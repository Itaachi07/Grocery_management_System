<<<<<<< HEAD
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import CartCard from "../../components/customer/cartcard";
import config from "../../config";
import { ClearCart } from "../../redux/actions/action";
export default function Cart() {
  const getdata = useSelector((state) => state.cartreducer.carts);
  const [price, setPrice] = useState(0);
  const dispatch = useDispatch();
  const navigate = useNavigate();
=======
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useSelector } from 'react-redux'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import CartCard from '../../components/customer/cartcard'
import config from '../../config'
export default function Cart() {
  const getdata = useSelector((state) => state.cartreducer.carts)
  const [price, setPrice] = useState(0)
  const navigate = useNavigate()
>>>>>>> 03fd970842a7125707b4ef6180edc0540c2d2984
  const total = () => {
    let price = 0
    getdata.map((ele, k) => {
      price = ele.p_price * ele.p_qty + price
    })
    setPrice(price)
  }
  useEffect(() => {
    total()
  }, [total])

  const checkout = () => {
<<<<<<< HEAD
    // console.log(getdata);
    // console.log(sessionStorage["token"]);
=======
    console.log(getdata)
    console.log(sessionStorage['token'])
>>>>>>> 03fd970842a7125707b4ef6180edc0540c2d2984
    let o_date =
      new Date().getFullYear() +
      '-' +
      new Date().getMonth() +
      '-' +
      new Date().getDate()
    const c_id = sessionStorage['c_id']

    const body = {
      c_id,
      o_date,
    }

    axios
      .post(config.customerURL + '/orders', body, {
        headers: { token: sessionStorage['token'] },
      })
      .then((response) => {
        const result = response.data
        if (result['status'] === 'success') {
          for (let index = 0; index < getdata.length; index++) {
<<<<<<< HEAD
            let o_id = result["data"];
            let p_qty = getdata[index].p_qty;
            let p_id = getdata[index].p_id;
            let s_id = getdata[index].s_id.s_id
              ? getdata[index].s_id.s_id
              : getdata[index].s_id;
            console.log("Oid is " + o_id);
=======
            let o_id = result['data']
            let p_qty = getdata[index].p_qty
            let p_id = getdata[index].p_id
            let s_id = getdata[index].s_id
            console.log('Oid is ' + o_id)
>>>>>>> 03fd970842a7125707b4ef6180edc0540c2d2984
            const body = {
              o_id,
              p_qty,
              p_id,
              s_id,
<<<<<<< HEAD
            };
            console.log("Inserting item index " + index);
            console.log(o_id, p_qty, p_id, s_id);
            axios
              .post(config.customerURL + "/order_details", body)
              .then((response) => {
                // console.log("Index is " + index);
              });
          }

          // toast.success("Order Placed Successfully");
          // dispatch(ClearCart(getdata));
          navigate("/payment", { state: { price: price } });
=======
            }

            axios
              .post(config.customerURL + '/order_details', body)
              .then((response) => {})
          }

          toast.success('Order Placed Successfully')
          navigate('/home')
>>>>>>> 03fd970842a7125707b4ef6180edc0540c2d2984
        } else {
          // toast.error(result["error"]);
          toast.error('Please login before Checkout')
          navigate('/login')
        }
      })
      .catch((error) => {
        console.log(error)
      })
  }

  return (
    <div style={{ display: 'flex', justifyContent: 'center' }}>
      {getdata.length ? (
        <div className='row' style={{ marginTop: '3%', width: '75%' }}>
          {getdata.map((p) => {
            return <CartCard key={p.p_id} product={p} />
          })}
          <strong className='mt-5 mb-5'>Total Amount : {price}</strong>

          <button onClick={checkout} className='btn btn-warning'>
            Proceed to Chekout
          </button>
        </div>
      ) : (
        <div className="container vh-100">
          <h1>Your shopping cart is empty now....</h1>
        </div>
      )}
    </div>
  )
}
