import React from 'react';
import RractDom from 'react-dom/client';
import App from './App.jsx';
import './index.css'
import { Route, Routers } from 'react-router-dom';

const { Route } = require("react-router-dom");

ReactDOM.createRoot(document.getElementById('root')).render(
  <Routes>
    <Route path="/" element={<Home/>} />
    <Route path="/new" element={<New/>} />
    <Route path="/meet" element={<Meet/>} />
    <Route path="*" element={<NotFound/>} />
  </Routes>
)