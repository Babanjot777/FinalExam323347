<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<style>

</style>
<head>
    <title>Savings Record</title>
</head>
<body>
<h1 style="text-align: center"><%= "Savings Investment Record" %>
</h1><br/>
<div>
    <p>The following are the savings records...</p><br/>
    <div>
        <table >
            <tr>
                <th>Customer number</th>
                <th>Customer Name</th>
                <th>Customer Deposit</th>
                <th>Number of years</th>
                <th>Savings Type</th>
            </tr>
            <tr>
                <td>115</td>
                <td>Jasper Diaz</td>
                <td>15000.0</td>
                <td>5</td>
                <td>Savings-Deluxe</td>
                <td><button>Edit</button></td>
                <td><button>Delete</button></td>
                <td><button>Projected Investment</button></td>
            </tr>
            <tr>
                <td>112</td>
                <td>Zanip Mendez</td>
                <td>5000.0</td>
                <td>2</td>
                <td>Savings-Deluxe</td>
                <td><button>Edit</button></td>
                <td><button>Delete</button></td>
                <td><button>Projected Investment</button></td>
            </tr>
            <tr>
                <td>113</td>
                <td>Geronima Esper</td>
                <td>6000.0</td>
                <td>5</td>
                <td>Savings-Regular</td>
                <td><button>Edit</button></td>
                <td><button>Delete</button></td>
                <td><button>Projected Investment</button></td>
            </tr>
        </table>
    </div>
</div>
<br/>
<a href="display-name"><button>Add</button></a>
</body>
</html>