import {User} from "../models/User";
import {useContext} from "react";
import LibraryContext from "../context/LibraryContext";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faHome} from "@fortawesome/free-solid-svg-icons/faHome";

function Header() {
    const headerStyles = {
        backgroundColor: "#292f32",
        color: "#cf37b9",
        margin: 0,
    };

    const user: User = useContext(LibraryContext).user;
    return (
        !user.isAdmin ?
        <header>
            <nav className="navbar navbar-expand-lg nav-fill w-100 bg-info">
            <div className="container-fluid">
                <Link className="navbar-brand" to={"/"}>
                    Librarian
                </Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <a className="nav-link active" aria-current="page" href="/">
                                <FontAwesomeIcon icon={faHome}/>
                            </a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/books">Books</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/books/user">My library</a>
                        </li>
                    </ul>
                    {user.username  ? <>{user.username}
                        <a href="/perform_logout"
                           style={{marginLeft: "10px"}}>
                            <button className="btn btn-danger">Logout</button>
                        </a>
                    </> : <>
                        <a href="/login" className="link-primary" style={{marginRight: "10px"}}>Login</a>
                        <Link to="/register" className="link-primary">Register</Link>
                    </>}
                </div>
            </div>
        </nav>
</header>
            :
        <header>
            <nav className="navbar navbar-expand-lg nav-fill w-100 bg-info">
                <div className="container-fluid">
                    <Link className="navbar-brand" to={"/"}>
                        Librarian
                    </Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/">
                                    <FontAwesomeIcon icon={faHome}/>
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/books">Books</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/admin/reservations">Reservations</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/admin/borrowings">Borrowings</a>
                            </li>
                        </ul>
                        {user.username ? <>Admin {user.username}
                            <a href="/perform_logout"
                               style={{marginLeft: "10px"}}>
                                <button className="btn btn-danger">Logout</button>
                            </a>
                        </> : <>
                            <a href="/login" className="link-primary" style={{marginRight: "10px"}}>Login</a>
                            <Link to="/register" className="link-primary">Register</Link>
                        </>}
                    </div>
                </div>
            </nav>
        </header>
    );
}

export default Header;