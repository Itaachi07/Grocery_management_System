import React, { useState } from 'react'
import ProductCard from '../../components/customer/productcard'
import config from '../../config'
import axios from 'axios'

export default function Searchedproducts() {
  const [products, setProducts] = useState([])
  const [query, setQuery] = useState('')
  const getProducts = () => {
    axios.get(config.adminURL + '/products_list').then((response) => {
      const result = response.data
      if (result) {
        setProducts(result)
      }
    })
  }
  getProducts()

  return (
    <div className='m-3'>
      <div className='input-group'>
        <input
          type='search'
          className='form-control rounded'
          placeholder='Search Your Products'
          aria-label='Search'
          aria-describedby='search-addon'
          onChange={(e) => setQuery(e.target.value)}
        />
      </div>
      <div>
        <div className='row' style={{ marginTop: '3%', width: '75%' }}>
          {products
            .filter((p) => p.p_name.toLowerCase().includes(query))
            .map((p) => {
              return <ProductCard key={p.p_id} product={p} />
            })}
        </div>
      </div>
    </div>
  )
}
