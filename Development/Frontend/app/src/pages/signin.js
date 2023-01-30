import { Link, useNavigate } from 'react-router-dom'
import config from '../config'
import axios from 'axios'
import { toast } from 'react-toastify'
import '../css/customer/login.css'
import { useState } from 'react'

const Signin = () => {
  const [s_email, setS_email] = useState('')
  const [s_password, setS_password] = useState('')

  const navigate = useNavigate()

  const signin = () => {
    if (s_email.length === 0) {
      toast.error('please enter email')
    } else if (s_password.length === 0) {
      toast.error('please enter password')
    } else if (s_email === 'admin@gms.com' && s_password === 'admin') {
      toast.success('You are successfully logged in.')
      navigate('/aseller')
    } else {
      axios
        .post(config.sellerURL + '/signin_auth', {
          s_email,
          s_password,
        })
        .then((response) => {
          const result = response
          console.log(result)

          if (result['data'] === 0) {
            toast.error('invalid s_email or s_password')
          } else {
            toast.success('Welcome to GMS')
            const id = result.data.s_id
            sessionStorage['id'] = id
            navigate('/sproduct')
          }
        })
    }
  }

  return (
    <div style={{ marginTop: 100 }}>
      <div style={styles.container}>
        <div className='mb-3'>
          <label>Email</label>
          <input
            onChange={(event) => {
              setS_email(event.target.value)
            }}
            className='form-control'
            type='s_email'
          />
        </div>
        <div className='mb-3'>
          <label>Password</label>
          <input
            onChange={(event) => {
              setS_password(event.target.value)
            }}
            className='form-control'
            type='s_password'
          />
        </div>
        <div className='mb-3' style={{ marginTop: 25 }}>
          <div>
            <Link to='/ssignup'>Signup</Link>
          </div>
          <button onClick={signin} style={styles.signinButton}>
            Signin
          </button>
        </div>
      </div>
    </div>
  )
}

const styles = {
  container: {
    width: 400,
    height: 325,
    padding: 30,
    position: 'relative',
    top: 0,
    left: 0,
    right: 0,
    bottom: 0,
    margin: 'auto',
    borderColor: '#C9C9C9',
    borderRadius: 10,
    broderWidth: 1,
    borderStyle: 'solid',
    boxShadow: '1px 1px 20px 5px #C9C9C9',
  },
  signinButton: {
    position: 'relative',
    width: '100%',
    height: 40,
    backgroundColor: '#27ae60',
    color: 'white',
    borderRadius: 5,
    border: 'none',
    marginTop: 10,
  },
}
export default Signin
