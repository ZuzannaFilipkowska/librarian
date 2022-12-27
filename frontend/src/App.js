import './App.css';
import {useEffect, useState} from "react";
import BookTable from "./components/BookTable";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {

    const [books, setBooks] = useState([
        { id: 1, name: 'George', animal: 'Monkey' },
        { id: 2, name: 'Jeffrey', animal: 'Giraffe' },
        { id: 3, name: 'Alice', animal: 'Giraffe' },
        { id: 4, name: 'Alice', animal: 'Tiger' },
    ]);
    const bookTableColumns = [
        {dataField: 'id', text: 'Id'},
        {dataField: 'name', text: 'Title'},
    ];

  useEffect(() => {
    fetch('/books').then(response => response.text())
      .then(books => console.log(books))
      .then(books => books != null ? setBooks(books) : console.log(books) );
  } )


  return (
      <Router>
          <div className="App">
              <Routes>
                  <Route
                      exact
                      path="/"
                      element={
                          <>
                              <BookTable books={books} columns={bookTableColumns}></BookTable>
                          </>
                      }
                  ></Route>
                  <Route path="/table" element={<BookTable books={books} columns={bookTableColumns} />} />
              </Routes>
          </div>
      </Router>
  );
}

export default App;
