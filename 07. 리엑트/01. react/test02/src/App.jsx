import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() { //App컴포넌트
  const [count, setCount] = useState(0)

  return (
    <>
      <div className='App'>
        Hello React
      </div>
    </>
  )
}

export default App
