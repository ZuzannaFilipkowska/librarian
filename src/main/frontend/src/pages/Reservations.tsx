import {useContext, useEffect, useState} from "react";
import LibraryContext from "../context/LibraryContext";
import {Book} from "../models/Book";
import {User} from "../models/User";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min'

function Reservations() {
    const [isLoading, setIsLoading] = useState(true);
    const [books, setBooks] = useState([]);
    const user: User = useContext(LibraryContext).user;
    const isAdmin: boolean = false;

    useEffect(() => {
        fetchBooks();
    }, []);

    const fetchBooks= async () => {
        const response = await fetch(`/api/books/user`);
        const data = await response.json();
        setBooks(data);
        setIsLoading(false);
    };

    if (!isLoading && (!books || books.length === 0)) {
        return <p>No books</p>;
    }
    return isLoading ? (
        <h3>Loading...</h3>
    ) : (
        <div>
            <table className="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope={"col"}>#</th>
                    <th scope={"col"}>Title</th>
                    <th scope={"col"}>Author</th>
                    <th scope={"col"}>Status</th>
                    {!user?.isAdmin && <th scope={"col"}>Action</th>}
                </tr>
                </thead>
                <tbody>
                {books.map((book: Book, index) => <tr key={book.id}>
                        <th scope={"row"}>{index + 1}</th>
                        <td>{book.title}</td>
                        <td>{book.author}</td>
                        <td>{book.status}</td>
                        {!user.isAdmin && <td>
                            {book.status === "AVAILABLE" &&
                                <button className="btn btn-info">
                                        {/*// onClick={() => handleBookReserve(book.id, book.version)}>*/}
                                    Book
                                </button>}
                        </td>}
                    </tr>
                )}
                </tbody>
            </table>

        </div>
    );
}

export default Reservations;