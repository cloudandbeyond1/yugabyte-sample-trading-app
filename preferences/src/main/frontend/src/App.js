import React, {Component} from 'react';
import Home from './components/Home';
import {HashRouter, Routes, Route} from "react-router-dom";
import Dashboard from "./components/Dashboard";
import Login from "./components/Login";
import Logout from "./components/Logout";
import Portfolio from "./components/Portfolio";
import MarketData from "./components/MarketData";
import Preferences from "./components/Preferences";
import AppNavbar from "./components/AppNavbar";
import SignUp from "./components/SignUp";
import ForgotPassword from "./components/ForgotPassword";
import NotFound from "./components/NotFound";

export default class App extends Component {
  render() {
    return (
      <HashRouter>
        <AppNavbar/>
        <div className='bg-light text-dark pt-5' style={{height: '100vh'}}>
          <div className='container'>
            <Routes>
              <Route path='/' exact={true} element={<Home/>}/>
              <Route path='/home' exact={true} element={<Home/>}/>
              <Route path='/dashboard' exact={true} element={<Dashboard/>}/>
              <Route path='/login' exact={true} element={<Login/>}/>
              <Route path='/forgot-password' exact={true} element={<ForgotPassword/>}/>
              <Route path='/signup' exact={true} element={<SignUp/>}/>
              <Route path='/logout' exact={true} element={<Logout/>}/>
              <Route path='/portfolio' exact={true} element={<Portfolio/>}/>
              <Route path='/market' exact={true} element={<MarketData/>}/>
              <Route path='/preferences' exact={true} element={<Preferences/>}/>
              <Route path="/**" element={<NotFound />} />
            </Routes>
          </div>
        </div>
      </HashRouter>
    )
  }
}
