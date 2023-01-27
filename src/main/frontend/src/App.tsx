import './App.css';
import { BrowserRouter as Router, Route, Routes} from "react-router-dom";
import React from 'react';
import {Registration} from "./components/Registration";
import {LibraryProvider} from "./context/LibraryContext";
import Header from "./components/Header";
import Reservations from "./pages/Reservations";
import Books from "./pages/Books";
import HomePage from "./pages/HomePage";
import AdminReservations from "./pages/AdminReservations";
import AdminBorrowed from "./pages/AdminBorrowed";

function App() {
  //  PLAN
    // wyszukiwarka
  // data rezerwacji check
  return (
      <LibraryProvider>
          <Router>
              <Header/>
              <div className="container pb-3">
                      <Routes>
                          <Route path={"/register"} element={<Registration/>}/>
                          <Route path={"/books"} element={<Books/>}/>
                          <Route path={"/books/user"} element={<Reservations/>}/>
                          <Route path={"/admin/reservations"} element={<AdminReservations/>}/>
                          <Route path={"/admin/borrowings"} element={<AdminBorrowed/>}/>
                          <Route path={"/"} element={<HomePage/>}/>
                          <Route path={"*"} element={<>Not found!</>}/>
                      </Routes>
              </div>
          </Router>
      </LibraryProvider>
  );
}

export default App;
