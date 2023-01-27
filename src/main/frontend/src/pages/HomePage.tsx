import {useContext, useEffect, useState} from "react";
import LibraryContext from "../context/LibraryContext";
import {Book} from "../models/Book";
import {User} from "../models/User";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min'
import {Link} from "react-router-dom";

function HomePage() {

    return (
        <div>
            <h1>Welcome to Library app.</h1>
            <h2> We are happy to have you with us!</h2>
            <a href="/login" className="link-primary" style={{marginRight: "10px"}}>Login</a>
            <Link to="/register" className="link-primary">Register</Link>
        </div>
    );
}

export default HomePage;