import BootstrapTable from 'react-bootstrap-table-next';

function BookTable({books, columns}) {
    return (
        <div>
            <BootstrapTable keyField='id' data={books} columns={columns} />
        </div>
    );
}

export default BookTable;